package com.hjf.beacon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ViewPager {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private String detail_url;
	private String img_url;
	public ViewPager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ViewPager(int id, String content, String detail_url, String img_url) {
		super();
		this.id = id;
		this.content = content;
		this.detail_url = detail_url;
		this.img_url = img_url;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "ViewPager [id=" + id + ", content=" + content + ", detail_url=" + detail_url + ", img_url=" + img_url
				+ "]";
	}
	
}
