package com.hjf.beacon.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeaconAppreciate implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String minor;
	private String major;
	private String img_url;
	private String title;
	private String content;
	private String video_url;
	private String audio_url;
	private boolean is_new;
	public BeaconAppreciate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BeaconAppreciate(String minor, String major, String img_url, String title, String content, String video_url,
			String audio_url, boolean is_new) {
		super();
		this.minor = minor;
		this.major = major;
		this.img_url = img_url;
		this.title = title;
		this.content = content;
		this.video_url = video_url;
		this.audio_url = audio_url;
		this.is_new = is_new;
	}
	public String getMinor() {
		return minor;
	}
	public void setMinor(String minor) {
		this.minor = minor;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getImg_url() {
		return img_url;
	}
	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public String getAudio_url() {
		return audio_url;
	}
	public void setAudio_url(String audio_url) {
		this.audio_url = audio_url;
	}
	public boolean isIs_new() {
		return is_new;
	}
	public void setIs_new(boolean is_new) {
		this.is_new = is_new;
		
	}
	@Override
	public String toString() {
		return "BeaconAppreciate [minor=" + minor + ", major=" + major + ", img_url=" + img_url + ", title=" + title
				+ ", content=" + content + ", video_url=" + video_url + ", audio_url=" + audio_url + ", is_new="
				+ is_new + "]";
	}
	
}
