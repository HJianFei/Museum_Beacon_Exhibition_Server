package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Foreign_History;
import com.hjf.beacon.service.ForeignHistoryService;
import com.hjf.beacon.utils.JSONUtils;

public class ForeignHistoryAction {

	private int pageSize = 10;
	private Foreign_History foreign_History;
	@Resource(name = "ForeignHistoryService")
	private ForeignHistoryService foreignHistoryService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		foreignHistoryService.save(foreign_History);
		String type = foreign_History.getType();
		getAllByType();
		if (type.equals("历史资料")) {
			return "foreignHistory_history";
		}else if (type.equals("人物故事")) {
			return "foreignHistory_people";
		}else if (type.equals("历史文化")) {
			return "foreignHistory_culture";
		}else if (type.equals("历史科技")) {
			return "foreignHistory_technology";
		}
		return "";
	}

	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type");
		System.out.println(type);
		foreignHistoryService.delete(Foreign_History.class, id);
		getAllByType();
		if (type.equals("历史资料")) {
			return "foreignHistory_history";
		}else if (type.equals("人物故事")) {
			return "foreignHistory_people";
		}else if (type.equals("历史文化")) {
			return "foreignHistory_culture";
		}else if (type.equals("历史科技")) {
			return "foreignHistory_technology";
		}
		return "";

	}
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			Foreign_History foreign_History = new Foreign_History();
			foreign_History =foreignHistoryService.find(Foreign_History.class, id);
			String type=foreign_History.getType();
			request.setAttribute("foreign_History",foreign_History);
			if (type.equals("历史资料")) {
				return "foreignHistory_history_change";
			}else if (type.equals("人物故事")) {
				return "foreignHistory_people_change";
			}else if (type.equals("历史文化")) {
				return "foreignHistory_culture_change";
			}else if (type.equals("历史科技")) {
				return "foreignHistory_technology_change";
			}
			return "";
		} else {
			foreignHistoryService.merge(foreign_History);
			String type=foreign_History.getType();
			getAllByType();
			if (type.equals("历史资料")) {
				return "foreignHistory_history";
			}else if (type.equals("人物故事")) {
				return "foreignHistory_people";
			}else if (type.equals("历史文化")) {
				return "foreignHistory_culture";
			}else if (type.equals("历史科技")) {
				return "foreignHistory_technology";
			}
			return "";
		}		
	}
	public String getAllByType() {

		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String title = request.getParameter("title");
		String type = request.getParameter("type");
		String country = request.getParameter("country");
		String query = "all";

		if (!title.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) foreignHistoryService.getResult("select count(*) from Foreign_History where type='"+type+"' and country='"+country+"'", 0, 0).iterator().next();
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
		List<Foreign_History> foreign_Histories = new ArrayList<>();

		String hql = "from Foreign_History where type='"+type+"' and country='"+country+"'";
		if (!query.equals("all")) {
			hql = "from Foreign_History where type='"+type+"' and title like '%" + title + "%'";
			foreign_Histories = foreignHistoryService.getResult(hql, 0, 0);
		} else {
			foreign_Histories = foreignHistoryService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("type", type);
		request.setAttribute("country", country);
		request.setAttribute("foreign_Histories", foreign_Histories);
		if (type.equals("历史资料")) {
			return "foreignHistory_history";
		}else if (type.equals("人物故事")) {
			return "foreignHistory_people";
		}else if (type.equals("历史文化")) {
			return "foreignHistory_culture";
		}else if (type.equals("历史科技")) {
			return "foreignHistory_technology";
		}
		return "";
	}

	public String getForeignHistory() {
		List<Foreign_History> foreign_Histories=new ArrayList<>();
		String type = request.getParameter("type");
		String country = request.getParameter("country");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition=request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from Foreign_History a where country='"+country+"' and type ='" + type + "' ORDER BY view DESC";
		if (null!=search_condition&&!search_condition.equals("")) {
			hql="from Foreign_History a where title like '%"+search_condition+"%' and country='"+country+"' and type ='" + type + "' ORDER BY view DESC";
		}
		foreign_Histories = foreignHistoryService.getResult(hql, pageSize * (page - 1), pageSize);
		if (foreign_Histories.size() > 0) {
			map.put("code", 200);
			map.put("foreign_Histories", foreign_Histories);
		} else {
			map.put("code", 500);
			map.put("foreign_Histories", foreign_Histories);
		}

		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public Foreign_History getForeign_History() {
		return foreign_History;
	}

	public void setForeign_History(Foreign_History foreign_History) {
		this.foreign_History = foreign_History;
	}

	//	public String updateViewCount() {
	//		String id = request.getParameter("id");
	//		String view_count = request.getParameter("view_count");
	//		String sql = "update appreciate set view_count=" + view_count + " where id='" + id + "'";
	//		int count = appreciateService.updateViewCount(sql);
	//		Map<String, Object> map = new HashMap<String, Object>();
	//		if (count > 0) {
	//			map.put("code", 200);
	//			map.put("msg", "更新成功");
	//
	//		} else {
	//			map.put("code", 500);
	//			map.put("msg", "服务器出错");
	//		}
	//		try {
	//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}

	//	public String getAppreciateByRandom() {
	//		List<Appreciate> appreciates=new ArrayList<>();
	//		Map<String, Object> map = new HashMap<String, Object>();
	//		String hql = "from Appreciate ORDER BY view_count DESC";
	//		 appreciates = appreciateService.getResult(hql, 0, 6);
	//		if (appreciates.size() > 0) {
	//			map.put("code", 200);
	//			map.put("appreciates", appreciates);
	//		} else {
	//			map.put("code", 500);
	//			map.put("appreciates", appreciates);
	//		}
	//		try {
	//			JSONUtils.toJson(ServletActionContext.getResponse(), map);
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//		return null;
	//
	//	}



}
