package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_People_Detail;
import com.hjf.beacon.service.ChinaHistoryPeopleDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryPeopleDetailAction {

	private China_History_People_Detail china_History_People_Detail;
	@Resource(name = "ChinaHistoryPeopleDetailService")
	private ChinaHistoryPeopleDetailService chinaHistoryPeopleDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryPeopleDetail() {
		China_History_People_Detail china_History_People_Detail=new China_History_People_Detail();
		 String detail_url=request.getParameter("detail_url");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_People_Detail= chinaHistoryPeopleDetailService.find(China_History_People_Detail.class, detail_url);
		if (china_History_People_Detail != null) {
			map.put("code", 200);
			map.put("china_History_People_Detail", china_History_People_Detail);
		} else {
			map.put("code", 500);
			map.put("china_History_People_Detail", china_History_People_Detail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_People_Detail getChina_History_People_Detail() {
		return china_History_People_Detail;
	}

	public void setChina_History_People_Detail(China_History_People_Detail china_History_People_Detail) {
		this.china_History_People_Detail = china_History_People_Detail;
	}

}
