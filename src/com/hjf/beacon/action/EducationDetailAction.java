package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.EducationDetail;
import com.hjf.beacon.service.EducationDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class EducationDetailAction {
	private EducationDetail educationDetail;
	@Resource(name = "EducationDetailService")
	private EducationDetailService educationDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getEducationDetails() {
		String detail_url = request.getParameter("detail_url");
//		 String detail_url ="http://www.gdmuseum.com/edu_text.php?blogid=104&title=С֪ʶ&classid=49";
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		// System.out.println(">>>" + detail_url);
		// String hql = "from ExhibitionDetail a where detail_url='" + type +
		// "'";
		// String hql = "from Exhibition a where type=0";
		EducationDetail educationDetail = educationDetailService.find(EducationDetail.class, detail_url);
		if (educationDetail != null) {
			status = "1";
			map.put("educationDetail", educationDetail);
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

	public EducationDetail getEducationDetail() {
		return educationDetail;
	}

	public void setEducationDetail(EducationDetail educationDetail) {
		this.educationDetail = educationDetail;
	}

}
