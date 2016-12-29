package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.FeedBack;
import com.hjf.beacon.service.FeedBackService;
import com.hjf.beacon.utils.JSONUtils;

public class FeedBackAction {

	private int pageSize = 10;
	private FeedBack feedBack;
	@Resource(name = "FeedBackService")
	private FeedBackService feedBackService;
	HttpServletRequest request = ServletActionContext.getRequest();

//	public String getAllAppreciate() {
//		String type = request.getParameter("type");
//		int page = Integer.parseInt(request.getParameter("page"));
//		String search_condition=request.getParameter("search_condition");
//		Map<String, Object> map = new HashMap<String, Object>();
//		String status = "0";
//		String hql = "from Appreciate a where type ='" + type + "' ORDER BY view_count DESC";
//		if (null!=search_condition&&!search_condition.equals("")) {
//			hql="from Appreciate a where content like '%"+search_condition+"%' and type ='" + type + "' ORDER BY view_count DESC";
//		}
//		List<Appreciate> appreciates = appreciateService.getResult(hql, pageSize * (page - 1), pageSize);
//		if (appreciates.size() > 0) {
//			status = "1";
//			map.put("appreciates", appreciates);
//		} else {
//			status = "null";
//		}
//		map.put("status", status);
//		try {
//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}

	public String saveFeedBack() {
		String phone = request.getParameter("phone");
		String content=request.getParameter("content");
		FeedBack feedBack=new FeedBack();
		feedBack.setPhone(phone);
		feedBack.setContent(content);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			feedBackService.save(feedBack);
			map.put("code", 200);
			map.put("msg", "反馈成功，感谢您的宝贵意见");
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "反馈成功，感谢您的宝贵意见");
			e.printStackTrace();
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public FeedBack getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(FeedBack feedBack) {
		this.feedBack = feedBack;
	}

//	public String getAppreciateByRandom() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String status = "0";
//		String hql = "from Appreciate ORDER BY view_count DESC";
//		List<Appreciate> appreciates = appreciateService.getResult(hql, 0, 6);
//		if (appreciates.size() > 0) {
//			status = "1";
//			map.put("appreciates", appreciates);
//		} else {
//			status = "null";
//		}
//		map.put("status", status);
//		try {
//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//
//	}

//	public String getNavigation() {
//		String minor = request.getParameter("minor");
//		Map<String, Object> map = new HashMap<String, Object>();
//		String status = "0";
//		String hql = "from Appreciate a where minor ='" + minor + "'";
//		List<Appreciate> app = appreciateService.getResult(hql, 0, 0);
//		// Appreciate app=appreciateService.find(Appreciate.class, minor);
//		if (null != app) {
//			status = "1";
//			map.put("appreciate", app);
//		} else {
//			status = "null";
//		}
//		map.put("status", status);
//		try {
//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//		return null;
//	}


}
