package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class China_History_Olden_War implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;
	private String name;
	private String img_url;
	private String description;
	private String detail_url;
	private String type;
	
	public China_History_Olden_War() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	@Override
	public String toString() {
		return "China_History_Olden_War [name=" + name + ", img_url=" + img_url + ", description=" + description
				+ ", detail_url=" + detail_url + ", type=" + type + "]";
	}
	
}
