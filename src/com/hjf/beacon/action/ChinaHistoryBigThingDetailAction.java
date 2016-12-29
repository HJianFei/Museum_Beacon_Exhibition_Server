package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Big_Thing_Detail;
import com.hjf.beacon.service.ChinaHistoryBigThingDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryBigThingDetailAction {
	private China_History_Big_Thing_Detail china_History_Big_Thing_Detail;
	@Resource(name = "ChinaHistoryBigThingDetailService")
	private ChinaHistoryBigThingDetailService chinaHistoryBigThingDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryBigThingDetail() {
		China_History_Big_Thing_Detail china_History_Big_Thing_Detail=new China_History_Big_Thing_Detail();
		String title = request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_Big_Thing_Detail = chinaHistoryBigThingDetailService.find(China_History_Big_Thing_Detail.class, title);
		if (china_History_Big_Thing_Detail!=null) {
			map.put("code", 200);
			map.put("china_History_Big_Thing_Detail", china_History_Big_Thing_Detail);
		} else {
			map.put("code", 500);
			map.put("china_History_Big_Thing_Detail", china_History_Big_Thing_Detail	);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public China_History_Big_Thing_Detail getChina_History_Big_Thing_Detail() {
		return china_History_Big_Thing_Detail;
	}

	public void setChina_History_Big_Thing_Detail(China_History_Big_Thing_Detail china_History_Big_Thing_Detail) {
		this.china_History_Big_Thing_Detail = china_History_Big_Thing_Detail;
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
