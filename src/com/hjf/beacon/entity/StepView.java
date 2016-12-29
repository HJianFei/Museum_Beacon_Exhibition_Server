package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StepView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String beacon_id;
	private String step_name;
	public StepView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StepView(String beacon_id, String step_name) {
		super();
		this.beacon_id = beacon_id;
		this.step_name = step_name;
	}
	public String getBeacon_id() {
		return beacon_id;
	}
	public void setBeacon_id(String beacon_id) {
		this.beacon_id = beacon_id;
	}
	public String getStep_name() {
		return step_name;
	}
	public void setStep_name(String step_name) {
		this.step_name = step_name;
	}
	@Override
	public String toString() {
		return "StepView [beacon_id=" + beacon_id + ", step_name=" + step_name + "]";
	}
	
}
