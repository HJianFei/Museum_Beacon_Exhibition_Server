package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class China_History_Olden_War_Detail implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String detail_url;
	private String name;
	private String army;
	private String result;
	private String time;
	private String address;
	private String figure;
	private String war_detail;
	public China_History_Olden_War_Detail() {
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
	public String getArmy() {
		return army;
	}
	public void setArmy(String army) {
		this.army = army;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFigure() {
		return figure;
	}
	public void setFigure(String figure) {
		this.figure = figure;
	}
	public String getWar_detail() {
		return war_detail;
	}
	public void setWar_detail(String war_detail) {
		this.war_detail = war_detail;
	}
	@Override
	public String toString() {
		return "China_History_Olden_War_Detail [detail_url=" + detail_url + ", name=" + name + ", army=" + army
				+ ", result=" + result + ", time=" + time + ", address=" + address + ", figure=" + figure
				+ ", war_detail=" + war_detail + "]";
	}
	
}
