package com.hjf.beacon.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.ViewPager;
import com.hjf.beacon.service.ViewPagerService;
import com.hjf.beacon.utils.JSONUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ViewPagerAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewPager viewPager;

	// 上传文件三要素
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String contentType;// 文件下载类型
	private String savePath;// 文件保存的路径
	@Resource(name = "ViewPagerService")
	private ViewPagerService viewPagerService;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 添加banner
	 * 
	 * @return
	 */
	public String save() {
		viewPagerService.save(viewPager, savePath, fileFileName);

		getAllViewPagerWeb();
		return "viewPager";
	}

	public String delete() {
		int id = Integer.parseInt(request.getParameter("id"));
		viewPagerService.delete(ViewPager.class, id);
		getAllViewPagerWeb();
		return "viewPager";
	}

	public String update() {
		String flag = request.getParameter("flag");
		int id = Integer.parseInt(request.getParameter("id"));
		ViewPager viewPager2 = new ViewPager();
		if (flag.equals("update")) {
			viewPager2 = viewPagerService.find(ViewPager.class, id);
			request.setAttribute("viewPager2", viewPager2);
			getAllViewPagerWeb();
		} else {
			viewPagerService.merge(viewPager, file, fileFileName);
			getAllViewPagerWeb();
		}
		return "viewPager";
	}

	/**
	 * 获取banner
	 * 
	 * @return
	 */
	public String getAllViewPagerWeb() {
		List<ViewPager> viewPagers = new ArrayList<ViewPager>();
		String hql = "from ViewPager";
		viewPagers = viewPagerService.getResult(hql, 0, 0);
		request.setAttribute("viewPagers", viewPagers);
		return "viewPager";
	}

	/**
	 * 查询全部banner
	 * 
	 * @return
	 */
	public String getAllViewPager() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ViewPager> viewPagers = new ArrayList<ViewPager>();
		String hql = "from ViewPager";
		viewPagers = viewPagerService.getResult(hql, 0, 0);
		if (viewPagers.size() > 0) {
			map.put("code", 200);
			map.put("viewPagers", viewPagers);
		} else {
			map.put("code", 200);
			map.put("viewPagers", viewPagers);
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ViewPager getViewPager() {
		return viewPager;
	}

	public void setViewPager(ViewPager viewPager) {
		this.viewPager = viewPager;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

}
