package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UpdateInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int id;
	private Integer error_code; // 错误代码
	private String error_msg; // 错误信息
	private String update_time;
	private String curVersion; // 当前版本
	private String appURL; // 下载地址
	private String description; // 描述
	private String minVersion; // 最低版本
	private String appName; // 应用名称
	

	public UpdateInfo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Integer getError_code() {
		return error_code;
	}


	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}


	public String getError_msg() {
		return error_msg;
	}


	public void setError_msg(String error_msg) {
		this.error_msg = error_msg;
	}


	public String getUpdate_time() {
		return update_time;
	}


	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}


	public String getCurVersion() {
		return curVersion;
	}


	public void setCurVersion(String curVersion) {
		this.curVersion = curVersion;
	}


	public String getAppURL() {
		return appURL;
	}


	public void setAppURL(String appURL) {
		this.appURL = appURL;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getMinVersion() {
		return minVersion;
	}


	public void setMinVersion(String minVersion) {
		this.minVersion = minVersion;
	}


	public String getAppName() {
		return appName;
	}


	public void setAppName(String appName) {
		this.appName = appName;
	}


	@Override
	public String toString() {
		return "当前版本: " + curVersion + ", 下载地址: " + appURL + ", 描述信息: " + description + ", 最低版本: "
				+ minVersion + ", 应用代称: " + appName + ", 错误代码: " + error_code + ", 错误信息: " + error_msg
				+ ",更新时间: " + update_time;
	}

}
