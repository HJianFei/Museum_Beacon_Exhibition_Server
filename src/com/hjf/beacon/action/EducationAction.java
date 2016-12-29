package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Education;
import com.hjf.beacon.service.EducationService;
import com.hjf.beacon.utils.JSONUtils;

public class EducationAction {

	private Education education;
	@Resource(name = "EducationService")
	private EducationService educationService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	public String getAllEducation() {
		Map<String, Object> map = new HashMap<String, Object>();
		String type=request.getParameter("type");
		String status = "0";
		String hql = "from Education a where type='" + type + "'";
		List<Education> educations = educationService.getResult(hql, 0, 0);
		if (educations.size() > 0) {
			status = "1";
			map.put("educations", educations);
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

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}
	

}
