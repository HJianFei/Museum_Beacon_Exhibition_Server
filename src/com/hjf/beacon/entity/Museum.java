package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Museum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int museum_id;
	private String museum_name;
	private String museum_img;
	private String museum_title;
	private int view_count;
	private String type;
	public Museum() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMuseum_id() {
		return museum_id;
	}
	public void setMuseum_id(int museum_id) {
		this.museum_id = museum_id;
	}
	public String getMuseum_name() {
		return museum_name;
	}
	public void setMuseum_name(String museum_name) {
		this.museum_name = museum_name;
	}
	public String getMuseum_img() {
		return museum_img;
	}
	public void setMuseum_img(String museum_img) {
		this.museum_img = museum_img;
	}
	public String getMuseum_title() {
		return museum_title;
	}
	public void setMuseum_title(String museum_title) {
		this.museum_title = museum_title;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Museum [museum_id=" + museum_id + ", museum_name=" + museum_name + ", museum_img=" + museum_img
				+ ", museum_title=" + museum_title + ", view_count=" + view_count + ", type=" + type + "]";
	}
	
}
