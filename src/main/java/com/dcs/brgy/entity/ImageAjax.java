package com.dcs.brgy.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageAjax {
	
	@JsonProperty("image")
	private String image;
	@JsonProperty("fullName")
	private String fullName;
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
