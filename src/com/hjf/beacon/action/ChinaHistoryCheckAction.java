package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Check;
import com.hjf.beacon.service.ChinaHistoryCheckService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryCheckAction {

	private int pageSize = 10;
	private China_History_Check check;
	@Resource(name = "ChinaHistoryCheckService")
	private ChinaHistoryCheckService checkService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllHistoryCheck() {
		List<China_History_Check> checks=new ArrayList<>();
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Check ORDER BY time DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from China_History_Check a where title like '%"+search_condition+"%' ORDER BY time DESC";
		}
		checks = checkService.getResult(hql, pageSize * (page - 1), pageSize);
		if (checks.size() > 0) {
			map.put("code", 200);
			map.put("checks", checks);
		} else {
			map.put("code", 500);
			map.put("checks", checks);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public China_History_Check getCheck() {
		return check;
	}

	public void setCheck(China_History_Check check) {
		this.check = check;
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
