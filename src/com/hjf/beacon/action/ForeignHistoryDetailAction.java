package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Foreign_History_Detail;
import com.hjf.beacon.service.ForeignHistoryDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ForeignHistoryDetailAction {
	private Foreign_History_Detail foreign_History_Detail;
	@Resource(name = "ForeignHistoryDetailService")
	private ForeignHistoryDetailService foreignHistoryDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getForeignHistoryDetail() {
		Foreign_History_Detail foreign_History_Detail=new Foreign_History_Detail();
		String title = request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		foreign_History_Detail = foreignHistoryDetailService.find(Foreign_History_Detail.class, title);
		
		 
		if (foreign_History_Detail!=null) {
			map.put("code", 200);
			map.put("foreign_History_Detail", foreign_History_Detail);
		} else {
			map.put("code", 500);
			map.put("foreign_History_Detail", foreign_History_Detail);
		}
		 System.out.println(foreign_History_Detail.toString());
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Foreign_History_Detail getForeign_History_Detail() {
		return foreign_History_Detail;
	}

	public void setForeign_History_Detail(Foreign_History_Detail foreign_History_Detail) {
		this.foreign_History_Detail = foreign_History_Detail;
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
