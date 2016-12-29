package com.hjf.beacon.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.Admin;
import com.hjf.beacon.service.AdminService;
import com.hjf.beacon.utils.MD5Util;

public class AdminAction {

	private int pageSize = 10;
	private Admin admin;
	@Resource(name = "AdminService")
	private AdminService adminService;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 保存
	 * 
	 * @return
	 */
	public String save() {
		admin.setAdmin_pwd(MD5Util.encrypt(admin.getAdmin_pwd()));
		adminService.save(admin);
		return null;
	}

	/**
	 * 管理员登录
	 * 
	 * @return
	 */
	public String login() {

		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String hql = "from Admin where admin_name='" + user_name + "' or admin_phone='" + user_name
				+ "' and admin_pwd='" + MD5Util.encrypt(user_pwd) + "'";
		List<Admin> admins = adminService.getResult(hql, 0, 0);
		if (admins.size() > 0) {
			return "success";
		} else {
			return "false";
		}
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
