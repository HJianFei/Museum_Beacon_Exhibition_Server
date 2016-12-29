package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Beacon;
import com.hjf.beacon.service.BeaconService;
import com.hjf.beacon.utils.JSONUtils;

public class BeaconAction {
	private Beacon beacon;
	@Resource(name = "BeaconService")
	private BeaconService beaconService;

	/**
	 * 增加Beacon信息
	 * 
	 * @return
	 */
	public String save() {
		beaconService.save(beacon);
		return "beacon";
	}

	public String getAllBeacon() {
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		String hql = "from Beacon";
		List<Beacon> beacons = beaconService.getResult(hql, 0, 0);
		if (beacons.size() > 0) {
			status = "1";
			map.put("beacons", beacons);
		} else {
			status = "null";
		}
		map.put("status", status);
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Beacon getBeacon() {
		return beacon;
	}

	public void setBeacon(Beacon beacon) {
		this.beacon = beacon;
	}

}
