package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Big_Thing;
import com.hjf.beacon.service.ChinaHistoryBigThingService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryBigThingAction {

	private int pageSize = 10;
	private China_History_Big_Thing china_History_Big_Thing;
	@Resource(name = "ChinaHistoryBigThingService")
	private ChinaHistoryBigThingService chinaHistoryBigThingService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String save() {
		chinaHistoryBigThingService.save(china_History_Big_Thing);
		getAllBigThingByType();
		return "chinaHistoryBigThing";
		
	}
	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		chinaHistoryBigThingService.delete(China_History_Big_Thing.class, id);
		getAllBigThingByType();
		return "chinaHistoryBigThing";
		
	}
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			China_History_Big_Thing big_Thing = new China_History_Big_Thing();
			big_Thing = chinaHistoryBigThingService.find(China_History_Big_Thing.class, id);
			request.setAttribute("big_Thing",big_Thing);
			return "chinaHistoryBigThing_change";
		} else {
			
			chinaHistoryBigThingService.merge(china_History_Big_Thing);
			getAllBigThingByType();
			return "chinaHistoryBigThing";
		}
		
	}
	
	public String getAllBigThingByType() {
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
		long pageMax = (Long) chinaHistoryBigThingService.getResult("select count(*) from China_History_Big_Thing where type='"+type+"'", 0, 0).iterator().next();
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
		List<China_History_Big_Thing> china_History_Big_Things = new ArrayList<>();

		String hql = "from China_History_Big_Thing where type='"+type+"'";
		if (!query.equals("all")) {
			hql = "from China_History_Big_Thing e where title like '%" + title + "%'";
			china_History_Big_Things = chinaHistoryBigThingService.getResult(hql, 0, 0);
		} else {
			china_History_Big_Things = chinaHistoryBigThingService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("type", type);
		request.setAttribute("BigThings", china_History_Big_Things);
		return "chinaHistoryBigThing";
	}

	public String getChinaHistoryBigThings() {
		List<China_History_Big_Thing> china_History_Big_Things=new ArrayList<>();
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Big_Thing where type='"+type+"'";
		china_History_Big_Things = chinaHistoryBigThingService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Big_Things.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Big_Things", china_History_Big_Things);
		} else {
			map.put("code", 500);
			map.put("china_History_Big_Things", china_History_Big_Things);
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

	public China_History_Big_Thing getChina_History_Big_Thing() {
		return china_History_Big_Thing;
	}

	public void setChina_History_Big_Thing(China_History_Big_Thing china_History_Big_Thing) {
		this.china_History_Big_Thing = china_History_Big_Thing;
	}
}
