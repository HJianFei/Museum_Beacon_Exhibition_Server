package com.hjf.beacon.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.UpdateInfo;
import com.hjf.beacon.service.UpdateService;
import com.hjf.beacon.utils.JSONUtils;

public class UpdateAction {

	private UpdateInfo updateInfo;

	@Resource(name = "UpdateService")
	private UpdateService updateService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String save() {
		
		updateService.save(updateInfo);
		getAllApp();
		return "update";
	}
	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		updateService.delete(UpdateInfo.class, id);
		getAllApp();
		return "update";
	}
	public String update() {

		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		if (flag.equals("update")) {
			UpdateInfo updateInfo = new UpdateInfo();
			updateInfo = updateService.find(UpdateInfo.class, id);
			request.setAttribute("updateInfo", updateInfo);
			return "update_change";
		} else {
			updateService.merge(updateInfo);
			getAllApp();
			return "update";
		}
		
	}


	public String getAllApp() {
		int pageSize = 3; // 每页显示记录条数
		int pageNow = 1; // 初始化页数
		String spageNow = request.getParameter("pagenow");
		if (!spageNow.equals("")) {
			pageNow = Integer.parseInt(spageNow);
		}
		long pageMax = (Long) updateService.getResult("select count(*) from UpdateInfo", 0, 0).iterator().next();
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
		List<UpdateInfo> updateInfos = new ArrayList<>();

		String hql = "from UpdateInfo ORDER BY update_time DESC";
		updateInfos = updateService.getResult(hql, (pageNow - 1) * pageSize, pageSize);
		request.setAttribute("show", "1"); // 是否显示分页
		request.setAttribute("pagenow", pageNow);
		request.setAttribute("pagecount", pageCount);
		request.setAttribute("updateInfos", updateInfos);
		return "update";
	}

	public String getAppUpdateInfo() {
		Map<String, Object> map = new HashMap<String, Object>();
		String hql = "from UpdateInfo ORDER BY update_time DESC";
		List<UpdateInfo> updateInfos = updateService.getResult(hql,0, 0);
		if (updateInfos.size() > 0) {
			UpdateInfo info = updateInfos.get(0);
			map.put("appUpdateInfo", info);
		} 
		else{
			map.put("appUpdateInfo", "null");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	public UpdateInfo getUpdateInfo() {
		return updateInfo;
	}

	public void setUpdateInfo(UpdateInfo updateInfo) {
		this.updateInfo = updateInfo;
	}

}
