package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Museum;
import com.hjf.beacon.service.MuseumService;
import com.hjf.beacon.utils.JSONUtils;

public class MuseumAction {

	private int pageSize = 6;
	private Museum museum;
	@Resource(name = "MuseumService")
	private MuseumService museumService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		String[] split = museum.getType().split(",");
		List<String> list = new ArrayList<>();
		for (String string : split) {
			list.add(string);
		}
		museum.setType(list.toString());
		museumService.save(museum);
		getAllMuseumWeb();
		return "museums";
	}

	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		museumService.delete(Museum.class, id);
		getAllMuseumWeb();
		return "museums";
	}

	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			Museum museum = new Museum();
			museum = museumService.find(Museum.class, id);
			String str=museum.getType().replace("[", "");
			str=str.replace("]", "");
			museum.setType(str);
			request.setAttribute("museum", museum);
			return "museum_change";
		} else {
			museum.setType("["+museum.getType()+"]");
			museumService.merge(museum);
			getAllMuseumWeb();
			return "museums";
		}
		
	}

	public String getAllMuseumWeb() {

		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String name = request.getParameter("name");
		String query = "all";

		if (!name.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) museumService.getResult("select count(*) from Museum", 0, 0).iterator().next();
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
		List<Museum> museums = new ArrayList<>();

		String hql = "from Museum ";
		if (!query.equals("all")) {
			hql = "from Museum e where museum_name like '%" + name + "%'";
			museums = museumService.getResult(hql, 0, 0);
		} else {
			museums = museumService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("museums", museums);
		return "museums";
	}

	public String getAllMuseum() {
		List<Museum> museums = new ArrayList<Museum>();
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition = request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Museum ORDER BY view_count DESC";
		if (null != search_condition && !search_condition.equals("")) {
			hql = "from Museum where museum_name like '%" + search_condition + "%' ORDER BY view_count DESC";
		}
		museums = museumService.getResult(hql, pageSize * (page - 1), pageSize);
		if (museums.size() > 0) {
			map.put("code", 200);
			map.put("museums", museums);
		} else {
			map.put("code", 200);
			map.put("museums", museums);
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
		String sql = "update museum set view_count=" + view_count + " where museum_id='" + id + "'";
		int count = museumService.updateViewCount(sql);
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

	public Museum getMuseum() {
		return museum;
	}

	public void setMuseum(Museum museum) {
		this.museum = museum;
	}
}
