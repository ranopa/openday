package com.kosta.openday.dtosample;

public class ClsInquiry {
	private Integer ciNum; // 문의번호
	private Integer ciTitle;// 제목
	private Integer ciContent; // 내용
	private Integer ciStatus; // 상태
	private Integer ciPostedDate; // 작성일
	private Integer userId; // 아이디
	private Integer clsId; // 클래스번호
	private Integer ciSecret; // 비밀글
	private Integer ciUpdateDate; // 수정일

	public ClsInquiry() {
	}

	public ClsInquiry(Integer ciNum, Integer ciTitle, Integer ciContent, Integer ciStatus, Integer ciPostedDate,
			Integer userId, Integer clsId, Integer ciSecret, Integer ciUpdateDate) {
		super();
		this.ciNum = ciNum;
		this.ciTitle = ciTitle;
		this.ciContent = ciContent;
		this.ciStatus = ciStatus;
		this.ciPostedDate = ciPostedDate;
		this.userId = userId;
		this.clsId = clsId;
		this.ciSecret = ciSecret;
		this.ciUpdateDate = ciUpdateDate;
	}

	public Integer getCiNum() {
		return ciNum;
	}

	public void setCiNum(Integer ciNum) {
		this.ciNum = ciNum;
	}

	public Integer getCiTitle() {
		return ciTitle;
	}

	public void setCiTitle(Integer ciTitle) {
		this.ciTitle = ciTitle;
	}

	public Integer getCiContent() {
		return ciContent;
	}

	public void setCiContent(Integer ciContent) {
		this.ciContent = ciContent;
	}

	public Integer getCiStatus() {
		return ciStatus;
	}

	public void setCiStatus(Integer ciStatus) {
		this.ciStatus = ciStatus;
	}

	public Integer getCiPostedDate() {
		return ciPostedDate;
	}

	public void setCiPostedDate(Integer ciPostedDate) {
		this.ciPostedDate = ciPostedDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public Integer getCiSecret() {
		return ciSecret;
	}

	public void setCiSecret(Integer ciSecret) {
		this.ciSecret = ciSecret;
	}

	public Integer getCiUpdateDate() {
		return ciUpdateDate;
	}

	public void setCiUpdateDate(Integer ciUpdateDate) {
		this.ciUpdateDate = ciUpdateDate;
	}
	
	
	
}
