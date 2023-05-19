package com.kosta.openday.dtosample;

public class AdmInquiry {
	private Integer admNum; // 문의번호
	private Integer admTitle; // 제목
	private Integer admContent; // 내용
	private Integer admType; // 유형
	private Integer admUploadDate; // 등록일
	private Integer admAnContent; // 답변내용
	private Integer admStatus; // 답변상태
	private Integer admAnDate; // 답변일
	private String userId; // 문의자id

	public AdmInquiry() {}

	public AdmInquiry(Integer admNum, Integer admTitle, Integer admContent, Integer admType, Integer admUploadDate,
			Integer admAnContent, Integer admStatus, Integer admAnDate, String userId) {
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

	public void setAdmNum(Integer admNum) {
		this.admNum = admNum;
	}

	public Integer getAdmTitle() {
		return admTitle;
	}

	public void setAdmTitle(Integer admTitle) {
		this.admTitle = admTitle;
	}

	public Integer getAdmContent() {
		return admContent;
	}

	public void setAdmContent(Integer admContent) {
		this.admContent = admContent;
	}

	public Integer getAdmType() {
		return admType;
	}

	public void setAdmType(Integer admType) {
		this.admType = admType;
	}

	public Integer getAdmUploadDate() {
		return admUploadDate;
	}

	public void setAdmUploadDate(Integer admUploadDate) {
		this.admUploadDate = admUploadDate;
	}

	public Integer getAdmAnContent() {
		return admAnContent;
	}

	public void setAdmAnContent(Integer admAnContent) {
		this.admAnContent = admAnContent;
	}

	public Integer getAdmStatus() {
		return admStatus;
	}

	public void setAdmStatus(Integer admStatus) {
		this.admStatus = admStatus;
	}

	public Integer getAdmAnDate() {
		return admAnDate;
	}

	public void setAdmAnDate(Integer admAnDate) {
		this.admAnDate = admAnDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
