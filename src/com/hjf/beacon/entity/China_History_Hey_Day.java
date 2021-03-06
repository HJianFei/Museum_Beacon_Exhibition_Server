package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class China_History_Hey_Day implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	private int id;
	private String title;
	private String img_url;
	private String detail_url;

	public China_History_Hey_Day() {
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

	public String getDetail_url() {
		return detail_url;
	}

	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "China_History_Hey_Day [title=" + title + ", img_url=" + img_url + ", detail_url=" + detail_url + "]";
	}

}
