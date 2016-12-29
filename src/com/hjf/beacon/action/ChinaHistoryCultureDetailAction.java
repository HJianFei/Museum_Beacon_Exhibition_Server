package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Culture_Detail;
import com.hjf.beacon.service.ChinaHistoryCultureDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryCultureDetailAction {

	private China_History_Culture_Detail china_History_Culture_Detail;
	@Resource(name = "ChinaHistoryCultureDetailService")
	private ChinaHistoryCultureDetailService chinaHistoryCultureDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryCultureDetail() {
		China_History_Culture_Detail china_History_Culture_Detail=new China_History_Culture_Detail();
		 String title=request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_Culture_Detail= chinaHistoryCultureDetailService.find(China_History_Culture_Detail.class, title);
		if (china_History_Culture_Detail != null) {
			map.put("code", 200);
			map.put("china_History_Culture_Detail", china_History_Culture_Detail);
		} else {
			map.put("code", 500);
			map.put("china_History_Culture_Detail", china_History_Culture_Detail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_Culture_Detail getChina_History_Culture_Detail() {
		return china_History_Culture_Detail;
	}

	public void setChina_History_Culture_Detail(China_History_Culture_Detail china_History_Culture_Detail) {
		this.china_History_Culture_Detail = china_History_Culture_Detail;
	}


}
