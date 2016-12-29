package com.hjf.beacon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cultural {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String time;
	private String intro;
	private String img_url;
	private String video_url;
	private String voice_url;
	private String major;
	private String minor;

	public Cultural(int id, String name, String time, String intro, String img_url, String video_url, String voice_url,
			String major, String minor) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.intro = intro;
		this.img_url = img_url;
		this.video_url = video_url;
		this.voice_url = voice_url;
		this.major = major;
		this.minor = minor;
	}

	public Cultural() {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public String getVoice_url() {
		return voice_url;
	}

	public void setVoice_url(String voice_url) {
		this.voice_url = voice_url;
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
		return "Cultural [id=" + id + ", name=" + name + ", time=" + time + ", intro=" + intro + ", img_url=" + img_url
				+ ", video_url=" + video_url + ", voice_url=" + voice_url + ", major=" + major + ", minor=" + minor
				+ "]";
	}

}
