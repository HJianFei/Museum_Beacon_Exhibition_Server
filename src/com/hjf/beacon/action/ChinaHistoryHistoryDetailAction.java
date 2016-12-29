package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_History_Detail;
import com.hjf.beacon.service.ChinaHistoryHistoryDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryHistoryDetailAction {

	private China_History_History_Detail china_History_History_Detail;
	@Resource(name = "ChinaHistoryHistoryDetailService")
	private ChinaHistoryHistoryDetailService chinaHistoryHistoryDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryHistoryDetail() {
		China_History_History_Detail china_History_History_Detail=new China_History_History_Detail();
		 String title=request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_History_Detail= chinaHistoryHistoryDetailService.find(China_History_History_Detail.class, title);
		if (china_History_History_Detail != null) {
			map.put("code", 200);
			map.put("china_History_History_Detail", china_History_History_Detail);
		} else {
			map.put("code", 500);
			map.put("china_History_History_Detail", china_History_History_Detail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_History_Detail getChina_History_History_Detail() {
		return china_History_History_Detail;
	}

	public void setChina_History_History_Detail(China_History_History_Detail china_History_History_Detail) {
		this.china_History_History_Detail = china_History_History_Detail;
	}

	


}
