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
