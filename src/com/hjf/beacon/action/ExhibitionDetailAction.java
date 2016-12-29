package com.hjf.beacon.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.ExhibitionDetail;
import com.hjf.beacon.service.ExhibitionDetailService;
import com.hjf.beacon.utils.JSONUtils;

public class ExhibitionDetailAction {

	private ExhibitionDetail exhibitionDetail;
	@Resource(name = "ExhibitionDetailService")
	private ExhibitionDetailService exhibitionDetailService;
	HttpServletRequest request = ServletActionContext.getRequest();

	public String getExhibitionDetails() {
		 String detail_url=request.getParameter("detail_url");
//		String detail_url = "http://www.gdmuseum.com/exhibit3_detail.php?picid=11180&LibID=43&gid=4&title=’π¿¿‘§∏Ê";
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
//		System.out.println(">>>" + detail_url);
		// String hql = "from ExhibitionDetail a where detail_url='" + type +
		// "'";
		// String hql = "from Exhibition a where type=0";
		ExhibitionDetail exhibitionDetail = exhibitionDetailService.find(ExhibitionDetail.class, detail_url);
		if (exhibitionDetail != null) {
			status = "1";
			map.put("exhibitionDetail", exhibitionDetail);
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

	public ExhibitionDetail getExhibitionDetail() {
		return exhibitionDetail;
	}

	public void setExhibitionDetail(ExhibitionDetail exhibitionDetail) {
		this.exhibitionDetail = exhibitionDetail;
	}

}
