package com.kosta.openday.adm.dto;

import java.sql.Date;

//일반문의
public class AdmInquiryDTO {
	private Integer admNum; //문의번호
	private String admTitle; //제목
	private String admContent; //내용
	private String admType; //유형
	private Date admUploadDate; //등록일
	private String admAnTitle; //답변내용
	private String admAnContent; //답변내용
	private boolean admStatus; //답변상태
	private Date admAnDate; //답변일
	private boolean admSecret; // 비밀글 
	private String userId; //문의자id

	public AdmInquiryDTO() {}

	public AdmInquiryDTO(Integer admNum, String admTitle, String admContent, String admType, Date admUploadDate,
			String admAnTitle, String admAnContent, boolean admStatus, Date admAnDate, String userId, boolean admSecret) {
		super();
		this.admNum = admNum;
		this.admTitle = admTitle;
		this.admContent = admContent;
		this.admType = admType;
		this.admUploadDate = admUploadDate;
		this.admAnTitle = admAnTitle;
		this.admAnContent = admAnContent;
		this.admStatus = admStatus;
		this.admAnDate = admAnDate;
		this.userId = userId;
		this.admSecret = admSecret;
	}

	public String getAdmAnTitle() {
		return admAnTitle;
	}

	public void setAdmAnTitle(String admAnTitle) {
		this.admAnTitle = admAnTitle;
	}

	public Integer getAdmNum() {
		return admNum;
	}

	public void setAdmNum(Integer admNum) {
		this.admNum = admNum;
	}

	public String getAdmTitle() {
		return admTitle;
	}

	public void setAdmTitle(String admTitle) {
		this.admTitle = admTitle;
	}

	public String getAdmContent() {
		return admContent;
	}

	public void setAdmContent(String admContent) {
		this.admContent = admContent;
	}

	public String getAdmType() {
		return admType;
	}

	public void setAdmType(String admType) {
		this.admType = admType;
	}

	public Date getAdmUploadDate() {
		return admUploadDate;
	}

	public void setAdmUploadDate(Date admUploadDate) {
		this.admUploadDate = admUploadDate;
	}

	public String getAdmAnContent() {
		return admAnContent;
	}

	public void setAdmAnContent(String admAnContent) {
		this.admAnContent = admAnContent;
	}

	public boolean isAdmStatus() {
		return admStatus;
	}

	public void setAdmStatus(boolean admStatus) {
		this.admStatus = admStatus;
	}

	public Date getAdmAnDate() {
		return admAnDate;
	}

	public void setAdmAnDate(Date admAnDate) {
		this.admAnDate = admAnDate;
	}

	public boolean isAdmSecret() {
		return admSecret;
	}

	public void setAdmSecret(boolean admSecret) {
		this.admSecret = admSecret;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
