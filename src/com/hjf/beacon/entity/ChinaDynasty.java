package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChinaDynasty implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dynasty;
	private String dynasty_detail;
	private String img_url;
	private String description;
	public ChinaDynasty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDynasty() {
		return dynasty;
	}
	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}
	public String getDynasty_detail() {
		return dynasty_detail;
	}
	public void setDynasty_detail(String dynasty_detail) {
		this.dynasty_detail = dynasty_detail;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "ChinaDynasty [id=" + id + ", dynasty=" + dynasty + ", dynasty_detail=" + dynasty_detail + ", img_url="
				+ img_url + ", description=" + description + "]";
	}
	
}
