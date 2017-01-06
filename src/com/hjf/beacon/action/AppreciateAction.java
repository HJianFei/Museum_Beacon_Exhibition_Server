package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Appreciate;
import com.hjf.beacon.service.AppreciateService;
import com.hjf.beacon.utils.JSONUtils;

public class AppreciateAction {

	private int pageSize = 10;
	private Appreciate appreciate;
	@Resource(name = "AppreciateService")
	private AppreciateService appreciateService;
	HttpServletRequest request = ServletActionContext.getRequest();
	
	
	public String save() {
		appreciateService.save(appreciate);
		getAllAppreciateWeb();
		return "appreciate";
		
	}
	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		appreciateService.delete(Appreciate.class, id);
		getAllAppreciateWeb();
		return "appreciate";
	}
	
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			Appreciate appreciate = new Appreciate();
			appreciate = appreciateService.find(Appreciate.class, id);
			request.setAttribute("appreciate", appreciate);
			return "appreciate_change";
		} else {
			appreciateService.merge(appreciate);
			getAllAppreciateWeb();
			return "appreciate";
		}
	}
	public String getAllAppreciateWeb() {
		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String museum = request.getParameter("museum");
		String title = request.getParameter("title");
		String query = "all";

		if (!title.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) appreciateService.getResult("select count(*) from Appreciate where museum_name='"+museum+"'", 0, 0).iterator()
				.next();
		long pageCount = 0;
		if (pageMax % pageSize == 0) {
			pageCount = pageMax / pageSize; // 总的页数
		} else {
			pageCount = (pageMax / pageSize) + 1;
		}
		if (pageNow > pageCount || pageNow < 1) {
			if (pageNow > pageCount) {
				pageNow = (int) pageCount;
			}
			if (pageNow < 1) {
				pageNow = 1;
			}
		}
		List<Appreciate> appreciates = new ArrayList<>();

		String hql = "from Appreciate where museum_name='"+museum+"'";
		if (!query.equals("all")) {
			hql = "from Appreciate e where content like '%" + title + "%'";
			appreciates = appreciateService.getResult(hql, 0, 0);
		} else {
			appreciates = appreciateService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("appreciates", appreciates);
		request.setAttribute("museum", museum);
		return "appreciate";
	}

	public String getAllAppreciate() {
		List<Appreciate> appreciates=new ArrayList<>();
		String type = request.getParameter("type");
		String museum_name = request.getParameter("museum_name");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Appreciate a where museum_name='"+museum_name+"' and type ='" + type + "' ";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from Appreciate a where content like '%"+search_condition+"%' and museum_name='"+museum_name+"' and type ='" + type + "' ORDER BY view_count DESC";
		}
		appreciates = appreciateService.getResult(hql, pageSize * (page - 1), pageSize);
		if (appreciates.size() > 0) {
			map.put("code", 200);
			map.put("appreciates", appreciates);
		} else {
			map.put("code", 500);
			map.put("appreciates", appreciates);
		}
	
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public String updateViewCount() {
		String id = request.getParameter("id");
		String view_count = request.getParameter("view_count");
		String sql = "update appreciate set view_count=" + view_count + " where id='" + id + "'";
		int count = appreciateService.updateViewCount(sql);
		Map<String, Object> map = new HashMap<String, Object>();
		if (count > 0) {
			map.put("code", 200);
			map.put("msg", "更新成功");

		} else {
			map.put("code", 500);
			map.put("msg", "服务器出错");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getAppreciateByRandom() {
		List<Appreciate> appreciates=new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Appreciate ORDER BY view_count DESC";
		 appreciates = appreciateService.getResult(hql, 0, 6);
		if (appreciates.size() > 0) {
			map.put("code", 200);
			map.put("appreciates", appreciates);
		} else {
			map.put("code", 500);
			map.put("appreciates", appreciates);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Appreciate getAppreciate() {
		return appreciate;
	}

	public void setAppreciate(Appreciate appreciate) {
		this.appreciate = appreciate;
	}

}
