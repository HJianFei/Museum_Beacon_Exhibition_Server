package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Check_Detail;
import com.hjf.beacon.service.ChinaHistoryCheckDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryCheckDetailAction {

	private China_History_Check_Detail check_Detail;
	@Resource(name = "ChinaHistoryCheckDetailService")
	private ChinaHistoryCheckDetailService checkDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getHistoryCheckDetail() {
		China_History_Check_Detail check_Detail=new China_History_Check_Detail();
		 String title=request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		check_Detail= checkDetailService.find(China_History_Check_Detail.class, title);
		if (check_Detail != null) {
			map.put("code", 200);
			map.put("check_Detail", check_Detail);
		} else {
			map.put("code", 500);
			map.put("check_Detail", check_Detail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_Check_Detail getCheck_Detail() {
		return check_Detail;
	}

	public void setCheck_Detail(China_History_Check_Detail check_Detail) {
		this.check_Detail = check_Detail;
	}

	
}
