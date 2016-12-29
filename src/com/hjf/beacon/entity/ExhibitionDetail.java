package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExhibitionDetail implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String detail_url;
	private String title;
	private String show_time;
	private String address;
	private String img_url;
	private String content;
	public ExhibitionDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ExhibitionDetail(String detail_url, String title, String show_time, String address, String img_url,
			String content) {
		super();
		this.detail_url = detail_url;
		this.title = title;
		this.show_time = show_time;
		this.address = address;
		this.img_url = img_url;
		this.content = content;
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
	public String getShow_time() {
		return show_time;
	}
	public void setShow_time(String show_time) {
		this.show_time = show_time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "ExhibitionDetail [detail_url=" + detail_url + ", title=" + title + ", show_time=" + show_time
				+ ", address=" + address + ", img_url=" + img_url + ", content=" + content + "]";
	}
	

}
