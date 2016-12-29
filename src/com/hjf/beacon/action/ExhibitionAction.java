package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Exhibition;
import com.hjf.beacon.service.ExhibitionService;
import com.hjf.beacon.utils.JSONUtils;

public class ExhibitionAction {

	private Exhibition exhibition;
	@Resource(name = "ExhibitionService")
	private ExhibitionService exhibitionService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllExhibition() {
		List<Exhibition> exhibitions=new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		String type=request.getParameter("type");
		String hql = "from Exhibition a where type='" + type + "'";
		exhibitions = exhibitionService.getResult(hql, 0, 0);
		if (exhibitions.size() > 0) {
			map.put("code", 200);
			map.put("exhibitions", exhibitions);
		} else {
			map.put("code", 500);
			map.put("exhibitions", exhibitions);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Exhibition getExhibition() {
		return exhibition;
	}

	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}

}
