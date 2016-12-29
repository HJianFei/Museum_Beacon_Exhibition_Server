package com.hjf.beacon.action;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.hjf.beacon.entity.User;
import com.hjf.beacon.service.UserService;
import com.hjf.beacon.utils.JSONUtils;

public class UserAction {

	private User user;
	@Resource(name = "UserService")
	private UserService userService;
	HttpServletRequest request = ServletActionContext.getRequest();
	// 上传文件三要素
	private File file;
	private String fileContentType;
	private String fileFileName;
	private String contentType;// 文件下载类型
	private String savePath;// 文件保存的路径

	public String saveUser() {
		String user_phone = request.getParameter("user_phone");
		String user_password = request.getParameter("user_password");
		User user = new User();
		user.setUser_phone(user_phone);
		user.setUser_password(user_password);
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			userService.save(user, file, savePath, fileFileName);
			map.put("code", "200");
			map.put("msg", "注册成功");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().startsWith("Duplicate entry")) {
				map.put("code", "404");
				map.put("msg", "用户已存在");
			} else {
				map.put("code", "500");
				map.put("msg", "服务器出错啦");
			}
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String updatePassword() {
		String phone = request.getParameter("phone");
		String new_password = request.getParameter("new_password");
		String old_password = request.getParameter("old_password");
		Map<String, Object> map = new HashMap<String, Object>();
		User u = userService.find(User.class, phone);
		if (null != u) {
			if (u.getUser_password().equals(old_password)) {
				u.setUser_password(new_password);
				try {
					userService.merge(u, file, fileFileName);
					map.put("code", 200);
					map.put("msg", "修改成功");
				} catch (Exception e) {
					map.put("code", 500);
					map.put("msg", "操作失败，稍后再试");
					e.printStackTrace();
				}

			} else {
				map.put("code", 400);
				map.put("msg", "旧密码错误");
			}
		} else {
			map.put("code", 404);
			map.put("msg", "用户不存在");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String changePhone() {
		String new_phone = request.getParameter("new_phone");
		String old_phone = request.getParameter("old_phone");
		Map<String, Object> map = new HashMap<String, Object>();
		User u = userService.find(User.class, old_phone);
		if (null != u) {
			try {
				userService.delete(User.class, old_phone);
				u.setUser_phone(new_phone);
				userService.save(u, file, savePath, fileFileName);
				map.put("code", 200);
				map.put("msg", "修改成功");
			} catch (Exception e) {
				map.put("code", 500);
				map.put("msg", "操作失败，稍后再试");
				e.printStackTrace();
			}
		} else {
			map.put("code", 404);
			map.put("msg", "用户不存在");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String changeName() {
		String user_phone = request.getParameter("user_phone");
		String name = request.getParameter("name");
		Map<String, Object> map = new HashMap<String, Object>();
		User u = userService.find(User.class, user_phone);
		if (null != u) {
			try {
				u.setUser_name(name);
				userService.merge(u, file, fileFileName);
				map.put("code", 200);
				map.put("msg", "修改成功");
			} catch (Exception e) {
				map.put("code", 500);
				map.put("msg", "操作失败，稍后再试");
				e.printStackTrace();
			}
		} else {
			map.put("code", 404);
			map.put("msg", "用户不存在");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String changeAvatar() {
		String user_phone = request.getParameter("user_phone");
		Map<String, Object> map = new HashMap<String, Object>();
		User u = userService.find(User.class, user_phone);
		if (null != u) {
			try {
				System.out.println("不为空");
				userService.merge(u, file, fileFileName);
				map.put("code", 200);
				map.put("msg", "修改成功");
			} catch (Exception e) {
				System.out.println("为空");
				map.put("code", 500);
				map.put("msg", "操作失败，稍后再试");
				e.printStackTrace();
			}
		} else {
			map.put("code", 404);
			map.put("msg", "用户不存在");
		}
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据手机号码查询用户信息
	 * 
	 * @return
	 */
	public String getUserByPhone() {
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<String, Object>();
		String status = "0";
		String msg = "";
		User u = userService.find(User.class, phone);
		if (null != u) {
			if (u.getUser_password().equals(password)) {
				status = "0";
				msg = "登陆成功";
			} else {
				u = null;
				msg = "密码错误";
				status = "1";
			}
		} else {
			u = null;
			msg = "用户不存在";
			status = "2";
		}
		map.put("msg", msg);
		map.put("user", u);
		map.put("status", status);
		try {
			JSONUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getAllAppreciate() {
		// String type = request.getParameter("type");
		// Map<String, Object> map = new HashMap<String, Object>();
		// String status = "0";
		// String hql = "from Appreciate a where type ='"+type+"'";
		// List<Appreciate> appreciates = userService.getResult(hql, 0, 0);
		// if (appreciates.size() > 0) {
		// status = "1";
		// map.put("appreciates", appreciates);
		// } else {
		// status = "null";
		// }
		// map.put("status", status);
		// try {
		// JSONUtils.toJson(ServletActionContext.getResponse(), map);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return null;

	}

	public String getAppreciateByRandom() {
		// Map<String, Object> map = new HashMap<String, Object>();
		// String status = "0";
		// String hql = "from Appreciate a ";
		// List<Appreciate> appreciates = appreciateService.getResult(hql, 4,
		// 4);
		// if (appreciates.size() > 0) {
		// status = "1";
		// map.put("appreciates", appreciates);
		// } else {
		// status = "null";
		// }
		// map.put("status", status);
		// try {
		// JSONUtils.toJson(ServletActionContext.getResponse(), map);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		return null;

	}

	public String getNavigation() {
		// String minor = request.getParameter("minor");
		// Map<String, Object> map = new HashMap<String, Object>();
		// String status = "0";
		// String hql = "from Appreciate a where minor ='"+minor+"'";
		// List<Appreciate> app = appreciateService.getResult(hql, 0, 0);
		//// Appreciate app=appreciateService.find(Appreciate.class, minor);
		// if (null!=app) {
		// status = "1";
		// map.put("appreciate", app);
		// } else {
		// status = "null";
		// }
		// map.put("status", status);
		// try {
		// JSONUtils.toJson(ServletActionContext.getResponse(), map);
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		return null;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
