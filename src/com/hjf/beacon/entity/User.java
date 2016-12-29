package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String user_phone;
	private String user_id;
	private String user_name;
	private String user_password;
	private String user_email;
	private String user_sex;
	private String user_qq;
	private String user_avatar_name;
	private String user_avatar_address;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_qq() {
		return user_qq;
	}
	public void setUser_qq(String user_qq) {
		this.user_qq = user_qq;
	}
	public String getUser_avatar_name() {
		return user_avatar_name;
	}
	public void setUser_avatar_name(String user_avatar_name) {
		this.user_avatar_name = user_avatar_name;
	}
	public String getUser_avatar_address() {
		return user_avatar_address;
	}
	public void setUser_avatar_address(String user_avatar_address) {
		this.user_avatar_address = user_avatar_address;
	}
	@Override
	public String toString() {
		return "User [user_phone=" + user_phone + ", user_id=" + user_id + ", user_name=" + user_name
				+ ", user_password=" + user_password + ", user_email=" + user_email + ", user_sex=" + user_sex
				+ ", user_qq=" + user_qq + ", user_avatar_name=" + user_avatar_name + ", user_avatar_address="
				+ user_avatar_address + "]";
	}
	
	
}
