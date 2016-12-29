package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.ChinaDynasty;
import com.hjf.beacon.service.ChinaDynastyService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaDynastyAction {

	private int pageSize = 10;
	private ChinaDynasty chinaDynasty;
	@Resource(name = "ChinaDynastyService")
	private ChinaDynastyService chinaDynastyService;
	HttpServletRequest request = ServletActionContext.getRequest();
	

	public String getAllChinaDynasty() {
		List<ChinaDynasty> chinaDynasties=new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		int page = Integer.parseInt(request.getParameter("page"));
		String hql = "from ChinaDynasty";
		chinaDynasties = chinaDynastyService.getResult(hql, pageSize * (page - 1), pageSize);
		for (ChinaDynasty chinaDynasty : chinaDynasties) {
			System.out.println(chinaDynasty.toString());
		}
		if (chinaDynasties.size() > 0) {
			map.put("code", 200);
			map.put("chinaDynasties", chinaDynasties);
		} else {
			map.put("code", 500);
			map.put("chinaDynasties", chinaDynasties);
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

	public ChinaDynasty getChinaDynasty() {
		return chinaDynasty;
	}

	public void setChinaDynasty(ChinaDynasty chinaDynasty) {
		this.chinaDynasty = chinaDynasty;
	}
	
}
