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
	public int id;
	public Integer error_code; // 错误代码
	public String error_msg; // 错误信息
	public String update_time;
	public String curVersion; // 当前版本
	public String appURL; // 下载地址
	public String description; // 描述
	public String minVersion; // 最低版本
	public String appName; // 应用名称

	@Override
	public String toString() {
		return "当前版本: " + curVersion + ", 下载地址: " + appURL + ", 描述信息: " + description + ", 最低版本: "
				+ minVersion + ", 应用代称: " + appName + ", 错误代码: " + error_code + ", 错误信息: " + error_msg
				+ ",更新时间: " + update_time;
	}

}
