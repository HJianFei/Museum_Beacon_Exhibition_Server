package com.hjf.beacon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Beacon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int beacob_id;
	private String ble_address;
	private String uuid;
	private String major;
	private String minor;

	public Beacon(int beacob_id, String ble_address, String uuid, String major, String minor) {
		super();
		this.beacob_id = beacob_id;
		this.ble_address = ble_address;
		this.uuid = uuid;
		this.major = major;
		this.minor = minor;
	}

	public Beacon() {

	}

	public int getBeacob_id() {
		return beacob_id;
	}

	public void setBeacob_id(int beacob_id) {
		this.beacob_id = beacob_id;
	}

	public String getBle_address() {
		return ble_address;
	}

	public void setBle_address(String ble_address) {
		this.ble_address = ble_address;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	@Override
	public String toString() {
		return "Beacon [beacob_id=" + beacob_id + ", ble_address=" + ble_address + ", uuid=" + uuid + ", major=" + major
				+ ", minor=" + minor + "]";
	}

}
