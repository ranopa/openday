package com.kosta.openday.notification.dto;

import java.sql.Date;

public class NotificationDTO {
	private Integer ntfId; // pk-auto
	private String ntfTitle;
	private String ntfContent;
	private String ntfType;
	private Date ntfCreatedAt;
	private Integer userNum; // fk-user
	
	public NotificationDTO() {}

	public NotificationDTO(Integer ntfId, String ntfTitle, String ntfContent, String ntfType, Date ntfCreatedAt,
			Integer userNum) {
		this.ntfId = ntfId;
		this.ntfTitle = ntfTitle;
		this.ntfContent = ntfContent;
		this.ntfType = ntfType;
		this.ntfCreatedAt = ntfCreatedAt;
		this.userNum = userNum;
	}

	public Integer getNtfId() {
		return ntfId;
	}

	public void setNtfId(Integer ntfId) {
		this.ntfId = ntfId;
	}

	public String getNtfTitle() {
		return ntfTitle;
	}

	public void setNtfTitle(String ntfTitle) {
		this.ntfTitle = ntfTitle;
	}

	public String getNtfContent() {
		return ntfContent;
	}

	public void setNtfContent(String ntfContent) {
		this.ntfContent = ntfContent;
	}

	public String getNtfType() {
		return ntfType;
	}

	public void setNtfType(String ntfType) {
		this.ntfType = ntfType;
	}

	public Date getNtfCreatedAt() {
		return ntfCreatedAt;
	}

	public void setNtfCreatedAt(Date ntfCreatedAt) {
		this.ntfCreatedAt = ntfCreatedAt;
	}

	public Integer getUserNum() {
		return userNum;
	}

	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}
	
	
	
}
