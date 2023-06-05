package com.kosta.openday.user.dto;

//클래스문의 T
public class ClsInquiryDTO {
	private Integer ciNum; // 문의번호
	private String ciTitle;// 제목
	private String ciContent; // 내용
	private Boolean ciStatus; // 상태
	private String ciDate; // 작성일
	private Boolean ciSecret; // 비밀글
	private String ciUpdateDate; // 수정일
	private String userId; // 아이디
	private Integer clsId; // 클래스번호

	public ClsInquiryDTO() {
	}

	public ClsInquiryDTO(Integer ciNum, String ciTitle, String ciContent, Boolean ciStatus, String ciDate,
			Boolean ciSecret, String ciUpdateDate, String userId, Integer clsId) {
		super();
		this.ciNum = ciNum;
		this.ciTitle = ciTitle;
		this.ciContent = ciContent;
		this.ciStatus = ciStatus;
		this.ciDate = ciDate;
		this.ciSecret = ciSecret;
		this.ciUpdateDate = ciUpdateDate;
		this.userId = userId;
		this.clsId = clsId;
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

	public String getCiDate() {
		return ciDate;
	}

	public void setCiDate(String ciDate) {
		this.ciDate = ciDate;
	}

	public Boolean getCiSecret() {
		return ciSecret;
	}

	public void setCiSecret(Boolean ciSecret) {
		this.ciSecret = ciSecret;
	}

	public String getCiUpdateDate() {
		return ciUpdateDate;
	}

	public void setCiUpdateDate(String ciUpdateDate) {
		this.ciUpdateDate = ciUpdateDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}


	

}
