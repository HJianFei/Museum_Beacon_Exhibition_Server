package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_History;
import com.hjf.beacon.service.ChinaHistoryHistoryService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryHistoryAction {

	private int pageSize = 10;
	private China_History_History china_History_History;
	@Resource(name = "ChinaHistoryHistoryService")
	private ChinaHistoryHistoryService chinaHistoryHistoryService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {

		chinaHistoryHistoryService.save(china_History_History);
		getAllByType();
		return "chinaHistoryHistory";
	}
	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		chinaHistoryHistoryService.delete(China_History_History.class, id);
		getAllByType();
		return "chinaHistoryHistory";

	}
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			China_History_History china_History_History = new China_History_History();
			china_History_History = chinaHistoryHistoryService.find(China_History_History.class, id);
			request.setAttribute("history",china_History_History);
			return "chinaHistoryHistory_change";
		} else {
			chinaHistoryHistoryService.merge(china_History_History);
			getAllByType();
			return "chinaHistoryHistory";
		}
	}
	public String getAllByType() {

		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String query = "all";

		if (!title.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) chinaHistoryHistoryService.getResult("select count(*) from China_History_History where type='"+type+"'", 0, 0).iterator().next();
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
		List<China_History_History> china_History_Histories = new ArrayList<>();

		String hql = "from China_History_History where type='"+type+"'";
		if (!query.equals("all")) {
			hql = "from China_History_History e where title like '%" + title + "%'";
			china_History_Histories = chinaHistoryHistoryService.getResult(hql, 0, 0);
		} else {
			china_History_Histories = chinaHistoryHistoryService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("type", type);
		request.setAttribute("china_History_Histories", china_History_Histories);
		return "chinaHistoryHistory";

	}
	public String getAllChinaHistoryHistory() {
		List<China_History_History> china_History_Histories=new ArrayList<>();
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_History c where type ='" + type + "' ORDER BY views DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from China_History_History c where title like '%"+search_condition+"%' and type ='" + type + "' ORDER BY views DESC";
		}
		china_History_Histories = chinaHistoryHistoryService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Histories.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Histories", china_History_Histories);
		} else {
			map.put("code", 500);
			map.put("china_History_Histories", china_History_Histories);
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
	//
	//	public String getAppreciateByRandom() {
	//		List<Appreciate> appreciates=new ArrayList<>();
	//		Map<String, Object> map = new HashMap<String, Object>();
	//		String hql = "from Appreciate ORDER BY view_count DESC";
	//		 appreciates = appreciateService.getResult(hql, 0, 6);
	//		if (appreciates.size() > 0) {
	//			map.put("code", 200);
	//			map.put("appreciates", appreciates);
	//		} else {
	//			map.put("code", 500);
	//			map.put("appreciates", appreciates);
	//		}
	//		try {
	//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		return null;
	//
	//	}



	public China_History_History getChina_History_History() {
		return china_History_History;
	}

	public void setChina_History_History(China_History_History china_History_History) {
		this.china_History_History = china_History_History;
	}



}
