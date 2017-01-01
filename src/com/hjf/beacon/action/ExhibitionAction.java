package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Exhibition;
import com.hjf.beacon.service.ExhibitionService;
import com.hjf.beacon.utils.JSONUtils;

public class ExhibitionAction {

	private Exhibition exhibition;
	@Resource(name = "ExhibitionService")
	private ExhibitionService exhibitionService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		exhibitionService.save(exhibition);
		getAllExhibitionByCity();
		return "exhibition";
	}
	
	public String update() {
		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			Exhibition exhibition = new Exhibition();
			exhibition = exhibitionService.find(Exhibition.class, id);
			request.setAttribute("exhibition", exhibition);
			return "exhibition_change";
		} else {
			exhibitionService.merge(exhibition);
			getAllExhibitionByCity();
			return "exhibition";
		}
		
	}

	public String delete() {

		int id = Integer.parseInt(request.getParameter("id"));
		exhibitionService.delete(Exhibition.class, id);
		getAllExhibitionByCity();
		return "exhibition";
	}

	public String getAllExhibitionByCity() {

		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		String city = request.getParameter("city");
		String tip = request.getParameter("tip");
		String query = "all";
		if (city.equals("中文/拼音")) {
			city = "";
		}
		if (!tip.equals("") || !city.equals("")) {
			query = "";
		}
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) exhibitionService.getResult("select count(*) from Exhibition", 0, 0).iterator().next();
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
		List<Exhibition> exhibitions = new ArrayList<>();

		String hql = "from Exhibition ";
		if (!query.equals("all")) {
			if (!city.equals("") && tip.equals("")) {
				hql = "from Exhibition e where type='" + city + "'";
			}
			if (!tip.equals("") && city.equals("")) {
				hql = "from Exhibition e where content like '%" + tip + "%'";
			}
			if (!tip.equals("") && !city.equals("")) {
				hql = "from Exhibition e where type='" + city + "' and content like '%" + tip + "%'";
			}
			exhibitions = exhibitionService.getResult(hql, 0, 0);
		} else {
			System.out.println("alllll");
			exhibitions = exhibitionService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
			request.setAttribute("show", "1"); // 是否显示分页
			request.setAttribute("pagenow", pageNow);
			request.setAttribute("pagecount", pageCount);
		}
		request.setAttribute("exhibitions", exhibitions);
		return "exhibition";
	}

	public String getAllExhibition() {
		List<Exhibition> exhibitions = new ArrayList<>();
		Map<String, Object> map = new HashMap<String, Object>();
		String type = request.getParameter("type");
		String hql = "from Exhibition a where type='" + type + "'";
		exhibitions = exhibitionService.getResult(hql, 0, 0);
		if (exhibitions.size() > 0) {
			map.put("code", 200);
			map.put("exhibitions", exhibitions);
		} else {
			map.put("code", 500);
			map.put("exhibitions", exhibitions);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Exhibition getExhibition() {
		return exhibition;
	}

	public void setExhibition(Exhibition exhibition) {
		this.exhibition = exhibition;
	}

}
