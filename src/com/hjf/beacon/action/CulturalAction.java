package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Cultural;
import com.hjf.beacon.service.CulturalService;
import com.hjf.beacon.utils.JSONUtils;

public class CulturalAction {

	private Cultural cultural;
	@Resource(name = "CulturalService")
	private CulturalService culturalService;

	/**
	 * 保存文物信息
	 * 
	 * @return
	 */
	public String save() {
		culturalService.save(cultural);
		return "cultural";
	}

	public String findByMinorId() {

		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		String minor=cultural.getMinor();
		System.out.println("minor:"+minor);
		String hql = "from Cultural where minor='"+minor+"'";
		List<Cultural> culturals = culturalService.getResult(hql, 0, 0);
		if (culturals.size() > 0) {
			status = "1";
			map.put("culturals", culturals);
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

	public Cultural getCultural() {
		return cultural;
	}

	public void setCultural(Cultural cultural) {
		this.cultural = cultural;
	}

}
