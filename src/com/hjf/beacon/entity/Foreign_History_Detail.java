package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Foreign_History_Detail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String title;
	private String author;
	private String time;
	private String img_url;
	private String detail_url;
	private String detail;
	public Foreign_History_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Override
	public String toString() {
		return "Foreign_History_Detail [title=" + title + ", author=" + author + ", time=" + time + ", img_url="
				+ img_url + ", detail_url=" + detail_url + ", detail=" + detail + "]";
	}
	
}
