package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Education implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String content;
	private String detail_url;
	private String content_time;
	private String type;
	public Education() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Education(int id, String content, String detail_url, String content_time, String type) {
		super();
		this.id = id;
		this.content = content;
		this.detail_url = detail_url;
		this.content_time = content_time;
		this.type = type;
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
	public String getContent_time() {
		return content_time;
	}
	public void setContent_time(String content_time) {
		this.content_time = content_time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", content=" + content + ", detail_url=" + detail_url + ", content_time="
				+ content_time + ", type=" + type + "]";
	}
	

}
