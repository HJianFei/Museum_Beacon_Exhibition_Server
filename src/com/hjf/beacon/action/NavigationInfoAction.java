package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.NavigationInfo;
import com.hjf.beacon.service.NavigationInfoService;
import com.hjf.beacon.utils.JSONUtils;

public class NavigationInfoAction {

	private NavigationInfo navigationInfo;
	@Resource(name = "NavigationInfoService")
	private NavigationInfoService navigationInfoService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getNavigationInfos() {
		String minor = request.getParameter("minor");
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		NavigationInfo naInfo = navigationInfoService.find(NavigationInfo.class, minor);
		if (naInfo != null) {
			status = "1";
			map.put("navigationInfo", naInfo);
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

	public NavigationInfo getNavigationInfo() {
		return navigationInfo;
	}

	public void setNavigationInfo(NavigationInfo navigationInfo) {
		this.navigationInfo = navigationInfo;
	}
	
}
