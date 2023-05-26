package com.kosta.openday.adm.dto;

import java.sql.Date;

//일반문의
public class AdmInquiryDTO {
	private Integer admNum; //문의번호
	private String admTitle; //제목
	private String admContent; //내용
	private String admType; //유형
	private Date admUploadDate; //등록일
	private String admAnContent; //답변내용
	private boolean admStatus; //답변상태
	private Date admAnDate; //답변일
	private String userId; //문의자id
	
	public AdmInquiryDTO() {}

	public AdmInquiryDTO(Integer admNum, String admTitle, String admContent, String admType, Date admUploadDate,
			String admAnContent, boolean admStatus, Date admAnDate, String userId) {
		super();
		this.admNum = admNum;
		this.admTitle = admTitle;
		this.admContent = admContent;
		this.admType = admType;
		this.admUploadDate = admUploadDate;
		this.admAnContent = admAnContent;
		this.admStatus = admStatus;
		this.admAnDate = admAnDate;
		this.userId = userId;
	}

	public Integer getAdmNum() {
		return admNum;
	}

	public String getAdmTitle() {
		return admTitle;
	}

	public String getAdmContent() {
		return admContent;
	}

	public String getAdmType() {
		return admType;
	}

	public Date getAdmUploadDate() {
		return admUploadDate;
	}

	public String getAdmAnContent() {
		return admAnContent;
	}

	public boolean isAdmStatus() {
		return admStatus;
	}

	public Date getAdmAnDate() {
		return admAnDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setAdmNum(Integer admNum) {
		this.admNum = admNum;
	}

	public void setAdmTitle(String admTitle) {
		this.admTitle = admTitle;
	}

	public void setAdmContent(String admContent) {
		this.admContent = admContent;
	}

	public void setAdmType(String admType) {
		this.admType = admType;
	}

	public void setAdmUploadDate(Date admUploadDate) {
		this.admUploadDate = admUploadDate;
	}

	public void setAdmAnContent(String admAnContent) {
		this.admAnContent = admAnContent;
	}

	public void setAdmStatus(boolean admStatus) {
		this.admStatus = admStatus;
	}

	public void setAdmAnDate(Date admAnDate) {
		this.admAnDate = admAnDate;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
