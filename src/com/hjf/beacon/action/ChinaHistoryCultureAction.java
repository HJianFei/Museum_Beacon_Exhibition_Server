package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Culture;
import com.hjf.beacon.service.ChinaHistoryCultureService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryCultureAction {

	private int pageSize = 10;
	private China_History_Culture china_History_Culture;
	@Resource(name = "ChinaHistoryCultureService")
	private ChinaHistoryCultureService chinaHistoryCultureService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllChinaHistoryCulture() {
		List<China_History_Culture> china_History_Cultures=new ArrayList<>();
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Culture c where type ='" + type + "' ORDER BY views DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from China_History_Culture c where title like '%"+search_condition+"%' and type ='" + type + "' ORDER BY views DESC";
		}
		china_History_Cultures = chinaHistoryCultureService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Cultures.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Cultures", china_History_Cultures);
		} else {
			map.put("code", 500);
			map.put("china_History_Cultures", china_History_Cultures);
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

	public China_History_Culture getChina_History_Culture() {
		return china_History_Culture;
	}

	public void setChina_History_Culture(China_History_Culture china_History_Culture) {
		this.china_History_Culture = china_History_Culture;
	}



}
