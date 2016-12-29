package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.StepView;
import com.hjf.beacon.service.StepViewService;
import com.hjf.beacon.utils.JSONUtils;

public class StepViewAction {

	private int pageSize = 10;
	private StepView stepView;
	@Resource(name = "StepViewService")
	private StepViewService stepViewService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getStepViewById() {

		String beacon_id = request.getParameter("beacon_id");
		System.out.println(beacon_id);
		Map<String, Object> map = new HashMap<String, Object>();
		StepView s = stepViewService.find(StepView.class, beacon_id);
		if (null != s) {
			map.put("code", 200);
			map.put("stepView", s);
		} else {
			map.put("code", 500);
			map.put("stepView", "null");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public String getAllAppreciate() {
	// String type = request.getParameter("type");
	// int page = Integer.parseInt(request.getParameter("page"));
	// String search_condition = request.getParameter("search_condition");
	// Map<String, Object> map = new HashMap<String, Object>();
	// String status = "0";
	// String hql = "from Appreciate a where type ='" + type + "' ORDER BY
	// view_count DESC";
	// if (null != search_condition && !search_condition.equals("")) {
	// hql = "from Appreciate a where content like '%" + search_condition + "%'
	// and type ='" + type
	// + "' ORDER BY view_count DESC";
	// }
	// List<Appreciate> appreciates = appreciateService.getResult(hql, pageSize
	// * (page - 1), pageSize);
	// if (appreciates.size() > 0) {
	// status = "1";
	// map.put("appreciates", appreciates);
	// } else {
	// status = "null";
	// }
	// map.put("status", status);
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }
	//
	// public String updateViewCount() {
	// String id = request.getParameter("id");
	// String view_count = request.getParameter("view_count");
	// String sql = "update appreciate set view_count=" + view_count + " where
	// id='" + id + "'";
	// int count = appreciateService.updateViewCount(sql);
	// Map<String, Object> map = new HashMap<String, Object>();
	// if (count > 0) {
	// map.put("code", 200);
	// map.put("msg", "更新成功");
	//
	// } else {
	// map.put("code", 500);
	// map.put("msg", "服务器出错");
	// }
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	// public String getAppreciateByRandom() {
	// Map<String, Object> map = new HashMap<String, Object>();
	// String status = "0";
	// String hql = "from Appreciate ORDER BY view_count DESC";
	// List<Appreciate> appreciates = appreciateService.getResult(hql, 0, 6);
	// if (appreciates.size() > 0) {
	// status = "1";
	// map.put("appreciates", appreciates);
	// } else {
	// status = "null";
	// }
	// map.put("status", status);
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }

	// public String getNavigation() {
	// String minor = request.getParameter("minor");
	// Map<String, Object> map = new HashMap<String, Object>();
	// String status = "0";
	// String hql = "from Appreciate a where minor ='" + minor + "'";
	// List<Appreciate> app = appreciateService.getResult(hql, 0, 0);
	// // Appreciate app=appreciateService.find(Appreciate.class, minor);
	// if (null != app) {
	// status = "1";
	// map.put("appreciate", app);
	// } else {
	// status = "null";
	// }
	// map.put("status", status);
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return null;
	// }

	public StepView getStepView() {
		return stepView;
	}

	public void setStepView(StepView stepView) {
		this.stepView = stepView;
	}

}
