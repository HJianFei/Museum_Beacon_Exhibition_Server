package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Museum;
import com.hjf.beacon.service.MuseumService;
import com.hjf.beacon.utils.JSONUtils;

public class MuseumAction {

	private int pageSize = 6;
	private Museum museum;
	@Resource(name = "MuseumService")
	private MuseumService museumService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllMuseum() {
		List<Museum> museums=new ArrayList<Museum>();
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition = request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Museum ORDER BY view_count DESC";
		if (null != search_condition && !search_condition.equals("")) {
			hql = "from Museum where museum_name like '%" + search_condition + "%' ORDER BY view_count DESC";
		}
		museums = museumService.getResult(hql, pageSize * (page - 1), pageSize);
		if (museums.size() > 0) {
			map.put("code", 200);
			map.put("museums", museums);
		} else {
			map.put("code", 200);
			map.put("museums", museums);
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
		String sql = "update museum set view_count=" + view_count + " where museum_id='" + id + "'";
		int count = museumService.updateViewCount(sql);
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

	public Museum getMuseum() {
		return museum;
	}

	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
}
