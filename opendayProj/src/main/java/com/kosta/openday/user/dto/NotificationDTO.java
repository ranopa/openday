package com.kosta.openday.user.dto;

import java.sql.Date;

//알림
public class NotificationDTO {
	private Integer ntfId; //알림번호
	private String ntfTitle; //알림제목
	private String ntfContent; //알림내용
	private String ntfType; //분류
	private Date ntfDate; //송신일
	private String userId; //받는사람
	
	public NotificationDTO() {}

	public NotificationDTO(Integer ntfId, String ntfTitle, String ntfContent, String ntfType, Date ntfDate,
			String userId) {
		super();
		this.ntfId = ntfId;
		this.ntfTitle = ntfTitle;
		this.ntfContent = ntfContent;
		this.ntfType = ntfType;
		this.ntfDate = ntfDate;
		this.userId = userId;
	}

	public Integer getNtfId() {
		return ntfId;
	}

	public String getNtfTitle() {
		return ntfTitle;
	}

	public String getNtfContent() {
		return ntfContent;
	}

	public String getNtfType() {
		return ntfType;
	}

	public Date getNtfDate() {
		return ntfDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setNtfId(Integer ntfId) {
		this.ntfId = ntfId;
	}

	public void setNtfTitle(String ntfTitle) {
		this.ntfTitle = ntfTitle;
	}

	public void setNtfContent(String ntfContent) {
		this.ntfContent = ntfContent;
	}

	public void setNtfType(String ntfType) {
		this.ntfType = ntfType;
	}

	public void setNtfDate(Date ntfDate) {
		this.ntfDate = ntfDate;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	 
}
