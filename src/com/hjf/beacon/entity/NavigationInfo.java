package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NavigationInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String minor;
	private String detail_url;
	private String content;
	private String img_url;
	public NavigationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NavigationInfo(String minor, String detail_url, String content, String img_url) {
		super();
		this.minor = minor;
		this.detail_url = detail_url;
		this.content = content;
		this.img_url = img_url;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
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
		return "NavigationInfo [minor=" + minor + ", detail_url=" + detail_url + ", content=" + content + ", img_url="
				+ img_url + "]";
	}

}
