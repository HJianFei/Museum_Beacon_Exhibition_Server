package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Olden_War_Detail;
import com.hjf.beacon.service.ChinaHistoryOldenWarDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryOldenWarDetailAction {

	private China_History_Olden_War_Detail china_History_Olden_War_Detail;
	@Resource(name = "ChinaHistoryOldenWarDetailService")
	private ChinaHistoryOldenWarDetailService chinaHistoryOldenWarDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryOldenWarDetails() {
		China_History_Olden_War_Detail china_History_Olden_War_Detail=new China_History_Olden_War_Detail();
		 String detail_url=request.getParameter("detail_url");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_Olden_War_Detail= chinaHistoryOldenWarDetailService.find(China_History_Olden_War_Detail.class, detail_url);
		if (china_History_Olden_War_Detail != null) {
			map.put("code", 200);
			map.put("china_History_Olden_War_Detail", china_History_Olden_War_Detail);
		} else {
			map.put("code", 500);
			map.put("china_History_Olden_War_Detail", china_History_Olden_War_Detail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_Olden_War_Detail getChina_History_Olden_War_Detail() {
		return china_History_Olden_War_Detail;
	}

	public void setChina_History_Olden_War_Detail(China_History_Olden_War_Detail china_History_Olden_War_Detail) {
		this.china_History_Olden_War_Detail = china_History_Olden_War_Detail;
	}

}
