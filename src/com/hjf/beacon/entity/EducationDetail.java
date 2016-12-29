package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EducationDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String detail_url;
	private String content;
	public EducationDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EducationDetail(String detail_url, String content) {
		super();
		this.detail_url = detail_url;
		this.content = content;
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
	@Override
	public String toString() {
		return "EducationDetail [detail_url=" + detail_url + ", content=" + content + "]";
	}
	
}
