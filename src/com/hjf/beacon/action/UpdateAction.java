package com.hjf.beacon.action;

import java.io.IOException;
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
