package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.AppreciateDetail;
import com.hjf.beacon.service.AppreciateDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class AppreciateDetailAction {

	private AppreciateDetail appreciateDetail;
	@Resource(name = "AppreciateDetailService")
	private AppreciateDetailService appreciateDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAppreciateDetails() {
		AppreciateDetail appreciateDetail=new AppreciateDetail();
		 String detail_url=request.getParameter("detail_url");
		Map<String, Object> map = new HashMap<String, Object>();
		appreciateDetail= appreciateDetailService.find(AppreciateDetail.class, detail_url);
		if (appreciateDetail != null) {
			map.put("code", 200);
			map.put("appreciateDetail", appreciateDetail);
		} else {
			map.put("code", 500);
			map.put("appreciateDetail", appreciateDetail);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public AppreciateDetail getAppreciateDetail() {
		return appreciateDetail;
	}

	public void setAppreciateDetail(AppreciateDetail appreciateDetail) {
		this.appreciateDetail = appreciateDetail;
	}
}
