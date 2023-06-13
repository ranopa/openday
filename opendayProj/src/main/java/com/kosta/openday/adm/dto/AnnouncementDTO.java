package com.kosta.openday.adm.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//공지사항
public class AnnouncementDTO {
	private Integer ancId; //글번호
	private String ancTitle; //제목
	private String  ancContent; //내용
	private Integer ancViewcount; //조회수
	private String ancType; //분류
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date ancUploadDate; //작성일 
	private Integer filNum; //파일번호
	
	public AnnouncementDTO() {}
	public AnnouncementDTO(Integer ancId, String ancTitle, String ancContent, Integer ancViewcount, String ancType,
			Date ancUploadDate, Integer filNum) {
		super();
		this.ancId = ancId;
		this.ancTitle = ancTitle;
		this.ancContent = ancContent;
		this.ancViewcount = ancViewcount;
		this.ancType = ancType;
		this.ancUploadDate = ancUploadDate;
		this.filNum = filNum;
	}
	public Integer getAncId() {
		return ancId;
	}
	public String getAncTitle() {
		return ancTitle;
	}
	public String getAncContent() {
		return ancContent;
	}
	public Integer getAncViewcount() {
		return ancViewcount;
	}
	public String getAncType() {
		return ancType;
	}
	public Date getAncUploadDate() {
		return ancUploadDate;
	}
	public Integer getFilNum() {
		return filNum;
	}
	public void setAncId(Integer ancId) {
		this.ancId = ancId;
	}
	public void setAncTitle(String ancTitle) {
		this.ancTitle = ancTitle;
	}
	public void setAncContent(String ancContent) {
		this.ancContent = ancContent;
	}
	public void setAncViewcount(Integer ancViewcount) {
		this.ancViewcount = ancViewcount;
	}
	public void setAncType(String ancType) {
		this.ancType = ancType;
	}
	public void setAncUploadDate(Date ancUploadDate) {
		this.ancUploadDate = ancUploadDate;
	}
	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}
	
	
	
}
