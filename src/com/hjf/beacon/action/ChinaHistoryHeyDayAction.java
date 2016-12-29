package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Hey_Day;
import com.hjf.beacon.service.ChinaHistoryHeyDayService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryHeyDayAction {

	private int pageSize = 10;
	private China_History_Hey_Day china_History_Hey_Day;
	@Resource(name = "ChinaHistoryHeyDayService")
	private ChinaHistoryHeyDayService chinaHistoryHeyDayService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllChinaHistoryHeyDays() {
		List<China_History_Hey_Day> china_History_Hey_Days=new ArrayList<>();
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Hey_Day";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from China_History_Hey_Day a where title like '%"+search_condition+"%'";
		}
		china_History_Hey_Days = chinaHistoryHeyDayService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Hey_Days.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Hey_Days", china_History_Hey_Days);
		} else {
			map.put("code", 500);
			map.put("china_History_Hey_Days", china_History_Hey_Days);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public China_History_Hey_Day getChina_History_Hey_Day() {
		return china_History_Hey_Day;
	}

	public void setChina_History_Hey_Day(China_History_Hey_Day china_History_Hey_Day) {
		this.china_History_Hey_Day = china_History_Hey_Day;
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
