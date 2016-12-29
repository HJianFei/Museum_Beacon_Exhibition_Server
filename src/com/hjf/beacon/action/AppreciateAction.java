package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Appreciate;
import com.hjf.beacon.service.AppreciateService;
import com.hjf.beacon.utils.JSONUtils;

public class AppreciateAction {

	private int pageSize = 10;
	private Appreciate appreciate;
	@Resource(name = "AppreciateService")
	private AppreciateService appreciateService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllAppreciate() {
		List<Appreciate> appreciates=new ArrayList<>();
		String type = request.getParameter("type");
		String museum_name = request.getParameter("museum_name");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Appreciate a where museum_name='"+museum_name+"' and type ='" + type + "' ";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from Appreciate a where content like '%"+search_condition+"%' and museum_name='"+museum_name+"' and type ='" + type + "' ORDER BY view_count DESC";
		}
		appreciates = appreciateService.getResult(hql, pageSize * (page - 1), pageSize);
		if (appreciates.size() > 0) {
			map.put("code", 200);
			map.put("appreciates", appreciates);
		} else {
			map.put("code", 500);
			map.put("appreciates", appreciates);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String updateViewCount() {
		String id = request.getParameter("id");
		String view_count = request.getParameter("view_count");
		String sql = "update appreciate set view_count=" + view_count + " where id='" + id + "'";
		int count = appreciateService.updateViewCount(sql);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("code", 200);
			map.put("msg", "更新成功");

		} else {
			map.put("code", 500);
			map.put("msg", "服务器出错");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAppreciateByRandom() {
		List<Appreciate> appreciates=new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Appreciate ORDER BY view_count DESC";
		 appreciates = appreciateService.getResult(hql, 0, 6);
		if (appreciates.size() > 0) {
			map.put("code", 200);
			map.put("appreciates", appreciates);
		} else {
			map.put("code", 500);
			map.put("appreciates", appreciates);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Appreciate getAppreciate() {
		return appreciate;
	}

	public void setAppreciate(Appreciate appreciate) {
		this.appreciate = appreciate;
	}

}
