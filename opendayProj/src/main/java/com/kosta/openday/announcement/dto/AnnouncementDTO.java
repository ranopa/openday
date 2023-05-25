package com.kosta.openday.announcement.dto;

import java.sql.Date;

public class AnnouncementDTO {
	private Integer ancId;
	private String ancTitle;
	private String ancContent;
	private Integer ancViewCount;
	private String ancType;
	private Date ancUploadDate;
	private Integer filNum;
	
	public AnnouncementDTO () {}
	
	public AnnouncementDTO(Integer ancId, String ancTitle, String ancContent, Integer ancViewCount, String ancType,
			Date ancUploadDate, Integer filNum) {
		this.ancId = ancId;
		this.ancTitle = ancTitle;
		this.ancContent = ancContent;
		this.ancViewCount = ancViewCount;
		this.ancType = ancType;
		this.ancUploadDate = ancUploadDate;
		this.filNum = filNum;
	}

	public Integer getAncId() {
		return ancId;
	}
	public void setAncId(Integer ancId) {
		this.ancId = ancId;
	}
	public String getAncTitle() {
		return ancTitle;
	}
	public void setAncTitle(String ancTitle) {
		this.ancTitle = ancTitle;
	}
	public String getAncContent() {
		return ancContent;
	}
	public void setAncContent(String ancContent) {
		this.ancContent = ancContent;
	}
	public Integer getAncViewCount() {
		return ancViewCount;
	}
	public void setAncViewCount(Integer ancViewCount) {
		this.ancViewCount = ancViewCount;
	}
	public String getAncType() {
		return ancType;
	}
	public void setAncType(String ancType) {
		this.ancType = ancType;
	}
	public Date getAncUploadDate() {
		return ancUploadDate;
	}
	public void setAncUploadDate(Date ancUploadDate) {
		this.ancUploadDate = ancUploadDate;
	}
	public Integer getFilNum() {
		return filNum;
	}
	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}
	
	
}
