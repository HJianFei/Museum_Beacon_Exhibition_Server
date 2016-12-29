package com.hjf.beacon.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Collection;
import com.hjf.beacon.service.CollectionService;
import com.hjf.beacon.utils.JSONUtils;

public class CollectionAction {

	SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private int pageSize = 10;
	private Collection collection;
	@Resource(name = "CollectionService")
	private CollectionService collectionService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getAllCollectionByType() {
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		String phone = request.getParameter("user_phone");
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		String hql = "from Collection where user_phone='" + phone + "' and post_type ='" + type
				+ "' ORDER BY created_time DESC";
		List<Collection> collections = collectionService.getResult(hql, pageSize * (page - 1), pageSize);
		if (collections.size() > 0) {
			status = "1";
			map.put("collections", collections);
			map.put("status", status);
		} else {
			map.put("status", status);
			map.put("collections", "null");
		}

		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String saveCollection() {
		String user_phone = request.getParameter("user_phone");
		String post_id = request.getParameter("post_id");
		String type = request.getParameter("post_type");
		String img_url = request.getParameter("img_url");
		String detail_url = request.getParameter("detail_url");
		Collection c = new Collection();
		c.setUser_phone(user_phone);
		c.setPost_id(post_id);
		c.setPost_type(type);
		c.setImg_url(img_url);
		c.setDetail_url(detail_url);
		c.setCreated_time(myFmt.format(new Date()));
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			collectionService.save(c);
			map.put("code", 200);
			map.put("msg", "收藏成功");
		} catch (Exception e) {
			map.put("code", 500);
			map.put("msg", "你已经收藏过啦");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String deleteCollection() {
		String user_phone = request.getParameter("user_phone");
		String post_id = request.getParameter("post_id");
		Map<String, Object> map = new HashMap<String, Object>();
		String sql="delete from collection where user_phone='"+user_phone+"' and post_id='"+post_id+"'";
			int result = collectionService.deleteCollection(sql);
			if (result>0) {
				map.put("code", 200);
				map.put("msg", "取消收藏成功");
			}else{
				map.put("code", 500);
				map.put("msg", "取消失败，稍后再试");
			}
		
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public String getAppreciateByRandom() {
	// Map<String, Object> map = new HashMap<String, Object>();
	// String status = "0";
	// String hql = "from Appreciate ORDER BY view_count DESC";
	// List<Appreciate> appreciates = appreciateService.getResult(hql, 0, 6);
	// if (appreciates.size() > 0) {
	// status = "1";
	// map.put("appreciates", appreciates);
	// } else {
	// status = "null";
	// }
	// map.put("status", status);
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }

	// public String getNavigation() {
	// String minor = request.getParameter("minor");
	// Map<String, Object> map = new HashMap<String, Object>();
	// String status = "0";
	// String hql = "from Appreciate a where minor ='" + minor + "'";
	// List<Appreciate> app = collectionService.getResult(hql, 0, 0);
	// // Appreciate app=appreciateService.find(Appreciate.class, minor);
	// if (null != app) {
	// status = "1";
	// map.put("appreciate", app);
	// } else {
	// status = "null";
	// }
	// map.put("status", status);
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	//
	// return null;
	// }

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

}
