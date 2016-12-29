package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Foreign_History;
import com.hjf.beacon.service.ForeignHistoryService;
import com.hjf.beacon.utils.JSONUtils;

public class ForeignHistoryAction {

	private int pageSize = 10;
	private Foreign_History foreign_History;
	@Resource(name = "ForeignHistoryService")
	private ForeignHistoryService foreignHistoryService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getForeignHistory() {
		List<Foreign_History> foreign_Histories=new ArrayList<>();
		String type = request.getParameter("type");
		String country = request.getParameter("country");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println(type);
		System.out.println(country);
		System.out.println(page);
		System.out.println(search_condition+">>");
		String hql = "from Foreign_History a where country='"+country+"' and type ='" + type + "' ORDER BY view DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from Foreign_History a where title like '%"+search_condition+"%' and country='"+country+"' and type ='" + type + "' ORDER BY view DESC";
		}
		foreign_Histories = foreignHistoryService.getResult(hql, pageSize * (page - 1), pageSize);
		if (foreign_Histories.size() > 0) {
			map.put("code", 200);
			map.put("foreign_Histories", foreign_Histories);
		} else {
			map.put("code", 500);
			map.put("foreign_Histories", foreign_Histories);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Foreign_History getForeign_History() {
		return foreign_History;
	}

	public void setForeign_History(Foreign_History foreign_History) {
		this.foreign_History = foreign_History;
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



}
