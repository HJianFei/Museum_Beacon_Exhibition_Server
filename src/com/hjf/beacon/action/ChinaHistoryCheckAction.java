package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.China_History_Check;
import com.hjf.beacon.service.ChinaHistoryCheckService;
import com.hjf.beacon.utils.JSONUtils;

public class ChinaHistoryCheckAction {

	private int pageSize = 10;
	private China_History_Check check;
	@Resource(name = "ChinaHistoryCheckService")
	private ChinaHistoryCheckService checkService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		checkService.save(check);
		getAllHistoryCheckWeb();
		return "chinaHistoryCheck";

	}
	public String update() {

		String flag = request.getParameter("flag");
		
		if (flag.equals("update")) {
			int id =Integer.parseInt(request.getParameter("id"));
			China_History_Check check = new China_History_Check();
			check = checkService.find(China_History_Check.class, id);
			request.setAttribute("check", check);
			return "chinaHistoryCheck_change";
		} else {
			checkService.merge(check);
			getAllHistoryCheckWeb();
			return "chinaHistoryCheck";
		}

	}

	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		checkService.delete(China_History_Check.class, id);
		getAllHistoryCheckWeb();
		return "chinaHistoryCheck";
	}

	public String getAllHistoryCheckWeb() {
		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String search_condition = request.getParameter("search");
		String query = "all";

		if (!search_condition.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) checkService.getResult("select count(*) from China_History_Check", 0, 0).iterator()
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
		List<China_History_Check> china_History_Checks = new ArrayList<>();

		String hql = "from China_History_Check ORDER BY time DESC";
		if (!query.equals("all")) {
			hql = "from China_History_Check e where title like '%" + search_condition + "%' ORDER BY time DESC";
			china_History_Checks = checkService.getResult(hql, 0, 0);
		} else {
			china_History_Checks = checkService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("china_History_Checks", china_History_Checks);
		return "chinaHistoryCheck";
	}

	public String getAllHistoryCheck() {
		List<China_History_Check> checks = new ArrayList<>();
		int page = Integer.parseInt(request.getParameter("page"));
		String search_condition = request.getParameter("search_condition");
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from China_History_Check ORDER BY time DESC";
		if (null != search_condition && !search_condition.equals("")) {
			hql = "from China_History_Check a where title like '%" + search_condition + "%' ORDER BY time DESC";
		}
		checks = checkService.getResult(hql, pageSize * (page - 1), pageSize);
		if (checks.size() > 0) {
			map.put("code", 200);
			map.put("checks", checks);
		} else {
			map.put("code", 500);
			map.put("checks", checks);
		}

		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public China_History_Check getCheck() {
		return check;
	}

	public void setCheck(China_History_Check check) {
		this.check = check;
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

}
