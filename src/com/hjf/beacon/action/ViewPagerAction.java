package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.ViewPager;
import com.hjf.beacon.service.ViewPagerService;
import com.hjf.beacon.utils.JSONUtils;

public class ViewPagerAction {
	private ViewPager viewPager;
	@Resource(name = "ViewPagerService")
	private ViewPagerService viewPagerService;

	/**
	 * ����Beacon��Ϣ
	 * 
	 * @return
	 */
	public String save() {
		viewPagerService.save(viewPager);
		return "viewPager";
	}

	public String getAllViewPager() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ViewPager> viewPagers=new ArrayList<ViewPager>();
		String hql = "from ViewPager";
		viewPagers= viewPagerService.getResult(hql, 0, 0);
		if (viewPagers.size() > 0) {
			map.put("code", 200);
			map.put("viewPagers", viewPagers);
		} else {
			map.put("code", 200);
			map.put("viewPagers", viewPagers);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ViewPager getViewPager() {
		return viewPager;
	}

	public void setViewPager(ViewPager viewPager) {
		this.viewPager = viewPager;
	}

}
