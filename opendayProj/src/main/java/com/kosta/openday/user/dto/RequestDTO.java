package com.kosta.openday.user.dto;

import java.util.Date;

public class RequestDTO {
	private Integer reqId; // 요청글번호
	private String reqTitle;// 제목
	private String reqContent;// 내용
	private Date reqDate;// 작성일
	private Integer reqViews;// 조회수
	private Date reqUpdateDate;// 수정일
	private String userId;// 작성자id
	private String reqLocation;// 장소
	
	public RequestDTO() {}

	public RequestDTO(Integer reqId, String reqTitle, String reqContent, Date reqDate, Integer reqViews,
			Date reqUpdateDate, String userId, String reqLocation) {
		super();
		this.reqId = reqId;
		this.reqTitle = reqTitle;
		this.reqContent = reqContent;
		this.reqDate = reqDate;
		this.reqViews = reqViews;
		this.reqUpdateDate = reqUpdateDate;
		this.userId = userId;
		this.reqLocation = reqLocation;
	}

	public Integer getReqId() {
		return reqId;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public String getReqContent() {
		return reqContent;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public Integer getReqViews() {
		return reqViews;
	}

	public Date getReqUpdateDate() {
		return reqUpdateDate;
	}

	public String getUserId() {
		return userId;
	}

	public String getReqLocation() {
		return reqLocation;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public void setReqViews(Integer reqViews) {
		this.reqViews = reqViews;
	}

	public void setReqUpdateDate(Date reqUpdateDate) {
		this.reqUpdateDate = reqUpdateDate;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setReqLocation(String reqLocation) {
		this.reqLocation = reqLocation;
	} 

	

}
