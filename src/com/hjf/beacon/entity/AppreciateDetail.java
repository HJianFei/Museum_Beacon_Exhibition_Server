package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AppreciateDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String detail_url;
	private String title;
	private String content;
	private String img_url;
	public AppreciateDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AppreciateDetail(String detail_url, String title, String content, String img_url) {
		super();
		this.detail_url = detail_url;
		this.title = title;
		this.content = content;
		this.img_url = img_url;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	@Override
	public String toString() {
		return "AppreciateDetail [detail_url=" + detail_url + ", title=" + title + ", content=" + content + ", img_url="
				+ img_url + "]";
	}
	

}
