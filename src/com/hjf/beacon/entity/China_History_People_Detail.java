package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class China_History_People_Detail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String detail_url;
	private String name;
	private String content;
	public China_History_People_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
