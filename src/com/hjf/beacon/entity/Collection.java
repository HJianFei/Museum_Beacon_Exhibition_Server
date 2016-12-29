package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(Collection.class)
public class Collection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private String user_phone;
	@Id
	private String post_id;
	private String post_type;
	private String created_time;
	private String img_url;
	private String detail_url;
	public Collection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Collection(String user_phone, String post_id, String post_type, String created_time, String img_url,
			String detail_url) {
		super();
		this.user_phone = user_phone;
		this.post_id = post_id;
		this.post_type = post_type;
		this.created_time = created_time;
		this.img_url = img_url;
		this.detail_url = detail_url;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPost_type() {
		return post_type;
	}
	public void setPost_type(String post_type) {
		this.post_type = post_type;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	@Override
	public String toString() {
		return "Collection [user_phone=" + user_phone + ", post_id=" + post_id + ", post_type=" + post_type
				+ ", created_time=" + created_time + ", img_url=" + img_url + ", detail_url=" + detail_url + "]";
	}
}
