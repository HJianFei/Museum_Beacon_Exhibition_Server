package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Museum_Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String museum_detail_name;
	private String museum_detail_content;
	private String museum_detail_imgs;
	public Museum_Detail( String museum_detail_name, String museum_detail_content,
			String museum_detail_imgs) {
		super();

		this.museum_detail_name = museum_detail_name;
		this.museum_detail_content = museum_detail_content;
		this.museum_detail_imgs = museum_detail_imgs;
	}
	public Museum_Detail() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMuseum_detail_name() {
		return museum_detail_name;
	}
	public void setMuseum_detail_name(String museum_detail_name) {
		this.museum_detail_name = museum_detail_name;
	}
	public String getMuseum_detail_content() {
		return museum_detail_content;
	}
	public void setMuseum_detail_content(String museum_detail_content) {
		this.museum_detail_content = museum_detail_content;
	}
	public String getMuseum_detail_imgs() {
		return museum_detail_imgs;
	}
	public void setMuseum_detail_imgs(String museum_detail_imgs) {
		this.museum_detail_imgs = museum_detail_imgs;
	}
	@Override
	public String toString() {
		return "MuseumDetail [museum_detail_name=" + museum_detail_name
				+ ", museum_detail_content=" + museum_detail_content + ", museum_detail_imgs=" + museum_detail_imgs
				+ "]";
	}
	

}
