package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class China_History_Hey_Day_InFo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String title;
	private String img_url;
	private String detail;
	public China_History_Hey_Day_InFo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "China_History_Hey_Day [title=" + title + ", img_url=" + img_url + ", detail=" + detail + "]";
	}
	

}
