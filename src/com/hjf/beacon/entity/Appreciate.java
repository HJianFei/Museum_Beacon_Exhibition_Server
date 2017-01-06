package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appreciate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String img_url;
	private String content;
	private String detail_url;
	private String type;
	private String minor;
	private int view_count;
	private String museum_name;
	public Appreciate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDetail_url() {
		return detail_url;
	}
	public void setDetail_url(String detail_url) {
		this.detail_url = detail_url;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getMuseum_name() {
		return museum_name;
	}
	public void setMuseum_name(String museum_name) {
		this.museum_name = museum_name;
	}
	@Override
	public String toString() {
		return "Appreciate [id=" + id + ", img_url=" + img_url + ", content=" + content + ", detail_url=" + detail_url
				+ ", type=" + type + ", minor=" + minor + ", view_count=" + view_count + ", museum_name=" + museum_name
				+ "]";
	}
	
	

}
