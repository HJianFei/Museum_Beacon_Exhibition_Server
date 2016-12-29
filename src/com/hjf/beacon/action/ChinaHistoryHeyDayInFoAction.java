package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Hey_Day_InFo;
import com.hjf.beacon.service.ChinaHistoryHeyDayInFoService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryHeyDayInFoAction {

	private China_History_Hey_Day_InFo china_History_Hey_Day_InFo;
	@Resource(name = "ChinaHistoryHeyDayInFoService")
	private ChinaHistoryHeyDayInFoService chinaHistoryHeyDayInFoService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getChinaHistoryHeyDayInFo() {
		China_History_Hey_Day_InFo china_History_Hey_Day_InFo=new China_History_Hey_Day_InFo();
		 String title=request.getParameter("title");
		Map<String, Object> map = new HashMap<String, Object>();
		china_History_Hey_Day_InFo= chinaHistoryHeyDayInFoService.find(China_History_Hey_Day_InFo.class, title);
		if (china_History_Hey_Day_InFo != null) {
			map.put("code", 200);
			map.put("china_History_Hey_Day_InFo", china_History_Hey_Day_InFo);
		} else {
			map.put("code", 500);
			map.put("china_History_Hey_Day_InFo", china_History_Hey_Day_InFo);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public China_History_Hey_Day_InFo getChina_History_Hey_Day_InFo() {
		return china_History_Hey_Day_InFo;
	}

	public void setChina_History_Hey_Day_InFo(China_History_Hey_Day_InFo china_History_Hey_Day_InFo) {
		this.china_History_Hey_Day_InFo = china_History_Hey_Day_InFo;
	}

}
