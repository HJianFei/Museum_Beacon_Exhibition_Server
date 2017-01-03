package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Olden_War;
import com.hjf.beacon.service.ChinaHistoryOldenWarService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryOldenWarAction {

	private int pageSize = 10;
	private China_History_Olden_War china_History_Olden_War;
	@Resource(name = "ChinaHistoryOldenWarService")
	private ChinaHistoryOldenWarService chinaHistoryOldenWarService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		chinaHistoryOldenWarService.save(china_History_Olden_War);
		getWarsWeb();
		return "chinaHistoryOldenWar";
	}

	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		chinaHistoryOldenWarService.delete(China_History_Olden_War.class, id);
		getWarsWeb();
		return "chinaHistoryOldenWar";
	}
	public String update() {
		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			China_History_Olden_War war = new China_History_Olden_War();
			war = chinaHistoryOldenWarService.find(China_History_Olden_War.class, id);
			request.setAttribute("war", war);
			return "chinaHistoryOldenWar_change";
		} else {
			chinaHistoryOldenWarService.merge(china_History_Olden_War);
			getWarsWeb();
			return "chinaHistoryOldenWar";
		}
	}

	public String getWarsWeb() {

		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String search_condition = request.getParameter("search");
		String type = request.getParameter("type");
		String query = "all";

		if (!search_condition.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) chinaHistoryOldenWarService
				.getResult("select count(*) from China_History_Olden_War where type='" + type + "'", 0, 0).iterator()
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
		List<China_History_Olden_War> wars = new ArrayList<>();

		String hql = "from China_History_Olden_War where type ='" + type + "'";
		if (!query.equals("all")) {
			hql = "from China_History_Olden_War e where type ='" + type + "' and name like '%" + search_condition
					+ "%'";
			wars = chinaHistoryOldenWarService.getResult(hql, 0, 0);
		} else {
			wars = chinaHistoryOldenWarService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
			request.setAttribute("type", type);
		}
		request.setAttribute("wars", wars);
		return "chinaHistoryOldenWar";

	}

	public String getAllChinaHistoryOldenWars() {
		List<China_History_Olden_War> china_History_Olden_Wars = new ArrayList<>();
		String type = request.getParameter("type");
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition = request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Olden_War a where type ='" + type + "'";
		if (null != search_condition && !search_condition.equals("")) {
			hql = "from China_History_Olden_War a where name like '%" + search_condition + "%' and type ='" + type
					+ "'";
		}
		china_History_Olden_Wars = chinaHistoryOldenWarService.getResult(hql, pageSize * (page - 1), pageSize);
		if (china_History_Olden_Wars.size() > 0) {
			map.put("code", 200);
			map.put("china_History_Olden_Wars", china_History_Olden_Wars);
		} else {
			map.put("code", 500);
			map.put("china_History_Olden_Wars", china_History_Olden_Wars);
		}

		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	// public String updateViewCount() {
	// String id = request.getParameter("id");
	// String view_count = request.getParameter("view_count");
	// String sql = "update appreciate set view_count=" + view_count + " where
	// id='" + id + "'";
	// int count = appreciateService.updateViewCount(sql);
	// Map<String, Object> map = new HashMap<String, Object>();
	// if (count > 0) {
	// map.put("code", 200);
	// map.put("msg", "更新成功");
	//
	// } else {
	// map.put("code", 500);
	// map.put("msg", "服务器出错");
	// }
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }

	// public String getAppreciateByRandom() {
	// List<Appreciate> appreciates=new ArrayList<>();
	// Map<String, Object> map = new HashMap<String, Object>();
	// String hql = "from Appreciate ORDER BY view_count DESC";
	// appreciates = appreciateService.getResult(hql, 0, 6);
	// if (appreciates.size() > 0) {
	// map.put("code", 200);
	// map.put("appreciates", appreciates);
	// } else {
	// map.put("code", 500);
	// map.put("appreciates", appreciates);
	// }
	// try {
	// JSONUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	//
	// }

	public China_History_Olden_War getChina_History_Olden_War() {
		return china_History_Olden_War;
	}

	public void setChina_History_Olden_War(China_History_Olden_War china_History_Olden_War) {
		this.china_History_Olden_War = china_History_Olden_War;
	}

}
