package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Museum_Detail;
import com.hjf.beacon.service.MuseumDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class MuseumDetailAction {
	private Museum_Detail museumDetail;
	@Resource(name = "MuseumDetailService")
	private MuseumDetailService msueumDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getMuseumDetails() {
		String museum_name = request.getParameter("museum_name");
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		Museum_Detail museum_Detail = msueumDetailService.find(Museum_Detail.class, museum_name);
		if (museum_Detail != null) {
			status = "1";
			map.put("museum_Detail", museum_Detail);
		} else {
			status = "null";
		}
		map.put("status", status);
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Museum_Detail getMuseumDetail() {
		return museumDetail;
	}

	public void setMuseumDetail(Museum_Detail museumDetail) {
		this.museumDetail = museumDetail;
	}

}
