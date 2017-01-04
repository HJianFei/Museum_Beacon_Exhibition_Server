package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_People;
import com.hjf.beacon.service.ChinaHistoryPeopleService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryPeopleAction {

	private int pageSize = 10;
	private China_History_People china_History_People;
	@Resource(name = "ChinaHistoryPeopleService")
	private ChinaHistoryPeopleService chinaHistoryPeopleService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save(){
		chinaHistoryPeopleService.save(china_History_People);
		getAllPeopleByType();
		return "chinaHistoryPeople";
	}
	
	public String delete(){
		int id = Integer.parseInt(request.getParameter("id"));
		chinaHistoryPeopleService.delete(China_History_People.class, id);
		getAllPeopleByType();
		return "chinaHistoryPeople";
	}
	
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			China_History_People people = new China_History_People();
			people = chinaHistoryPeopleService.find(China_History_People.class, id);
			request.setAttribute("people",people);
			return "chinaHistoryPeople_change";
		} else {
			
			chinaHistoryPeopleService.merge(china_History_People);
			getAllPeopleByType();
			return "chinaHistoryPeople";
		}
		
	}
	public String getAllPeopleByType(){
		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String query = "all";

		if (!name.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) chinaHistoryPeopleService.getResult("select count(*) from China_History_People where type='"+type+"'", 0, 0).iterator().next();
		long pageCount = 0;
		if (pageMax % pageSize == 0) {
			pageCount = pageMax / pageSize; // 总的页数
		} else {
			pageCount = (pageMax / pageSize) + 1;
		}
		if (pageNow > pageCount || pageNow < 1) {
			if (pageNow > pageCount) {
				pageNow = (int) pageCount;
			}
			if (pageNow < 1) {
				pageNow = 1;
			}
		}
		List<China_History_People> china_History_Peoples = new ArrayList<>();

		String hql = "from China_History_People where type='"+type+"'";
		if (!query.equals("all")) {
			hql = "from China_History_People e where name like '%" + name + "%'";
			china_History_Peoples = chinaHistoryPeopleService.getResult(hql, 0, 0);
		} else {
			china_History_Peoples = chinaHistoryPeopleService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("type", type);
		request.setAttribute("china_History_Peoples", china_History_Peoples);
		return "chinaHistoryPeople";
	}
	public String getAllHistoryPeople() {
		List<China_History_People> china_History_Peoples=new ArrayList<>();
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_People a where type ='" + type + "' ORDER BY views DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from China_History_People a where name like '%"+search_condition+"%' and type ='" + type + "' ORDER BY views DESC";
		}
		china_History_Peoples = chinaHistoryPeopleService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Peoples.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Peoples", china_History_Peoples);
		} else {
			map.put("code", 500);
			map.put("china_History_Peoples", china_History_Peoples);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

//	public String updateViewCount() {
//		String id = request.getParameter("id");
//		String view_count = request.getParameter("view_count");
//		String sql = "update appreciate set view_count=" + view_count + " where id='" + id + "'";
//		int count = appreciateService.updateViewCount(sql);
//		Map<String, Object> map = new HashMap<String, Object>();
//		if (count > 0) {
//			map.put("code", 200);
//			map.put("msg", "更新成功");
//
//		} else {
//			map.put("code", 500);
//			map.put("msg", "服务器出错");
//		}
//		try {
//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	public String getChinaHistoryPeopleByRandom() {
		List<China_History_People> china_History_Peoples=new ArrayList<>();
		String type = request.getParameter("type");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_People where type='"+type+"' ORDER BY views DESC";
		china_History_Peoples = chinaHistoryPeopleService.getResult(hql, 0, 6);
		if (china_History_Peoples.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Peoples", china_History_Peoples);
		} else {
			map.put("code", 500);
			map.put("china_History_Peoples", china_History_Peoples);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public China_History_People getChina_History_People() {
		return china_History_People;
	}

	public void setChina_History_People(China_History_People china_History_People) {
		this.china_History_People = china_History_People;
	}

}
