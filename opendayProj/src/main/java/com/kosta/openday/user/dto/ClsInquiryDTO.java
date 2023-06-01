package com.kosta.openday.user.dto;

import java.sql.Date;

//클래스문의 T
public class ClsInquiryDTO {
	private Integer ciNum; // 문의번호
	private String ciTitle;// 제목
	private String ciContent; // 내용
	private Boolean ciStatus; // 상태
	private Date ciDate; // 작성일
	private Boolean ciSecret; // 비밀글
	private Date ciUpdateDate; // 수정일
	private String userId; // 아이디
	private Integer scdNum; // 클래스번호

	public ClsInquiryDTO() {
	}

	public ClsInquiryDTO(Integer ciNum, String ciTitle, String ciContent, Boolean ciStatus, Date ciDate,
			Boolean ciSecret, Date ciUpdateDate, String userId, Integer scdNum) {
		super();
		this.ciNum = ciNum;
		this.ciTitle = ciTitle;
		this.ciContent = ciContent;
		this.ciStatus = ciStatus;
		this.ciDate = ciDate;
		this.ciSecret = ciSecret;
		this.ciUpdateDate = ciUpdateDate;
		this.userId = userId;
		this.scdNum = scdNum;
	}

	public Integer getCiNum() {
		return ciNum;
	}

	public void setCiNum(Integer ciNum) {
		this.ciNum = ciNum;
	}

	public String getCiTitle() {
		return ciTitle;
	}

	public void setCiTitle(String ciTitle) {
		this.ciTitle = ciTitle;
	}

	public String getCiContent() {
		return ciContent;
	}

	public void setCiContent(String ciContent) {
		this.ciContent = ciContent;
	}

	public Boolean getCiStatus() {
		return ciStatus;
	}

	public void setCiStatus(Boolean ciStatus) {
		this.ciStatus = ciStatus;
	}

	public Date getCiDate() {
		return ciDate;
	}

	public void setCiDate(Date ciDate) {
		this.ciDate = ciDate;
	}

	public Boolean getCiSecret() {
		return ciSecret;
	}

	public void setCiSecret(Boolean ciSecret) {
		this.ciSecret = ciSecret;
	}

	public Date getCiUpdateDate() {
		return ciUpdateDate;
	}

	public void setCiUpdateDate(Date ciUpdateDate) {
		this.ciUpdateDate = ciUpdateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}


}
