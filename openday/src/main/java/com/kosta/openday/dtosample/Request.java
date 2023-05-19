package com.kosta.openday.dtosample;

import java.util.Date;

public class Request {
	private Integer reqId; // 요청글번호
	private String reqTitle;// 제목
	private String reqContent;// 내용
	private Date reqDate;// 작성일
	private Integer reqViews;// 조회수
	private String userId;// 작성자id
	private Date reqUpdateDate;// 수정일

	public Request() {}

	public Request(Integer reqId, String reqTitle, String reqContent, Date reqDate, Integer reqViews, String userId,
			Date reqUpdateDate) {
		super();
		this.reqId = reqId;
		this.reqTitle = reqTitle;
		this.reqContent = reqContent;
		this.reqDate = reqDate;
		this.reqViews = reqViews;
		this.userId = userId;
		this.reqUpdateDate = reqUpdateDate;
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

	public String getReqTitle() {
		return reqTitle;
	}

	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}

	public String getReqContent() {
		return reqContent;
	}

	public void setReqContent(String reqContent) {
		this.reqContent = reqContent;
	}

	public Date getReqDate() {
		return reqDate;
	}

	public void setReqDate(Date reqDate) {
		this.reqDate = reqDate;
	}

	public Integer getReqViews() {
		return reqViews;
	}

	public void setReqViews(Integer reqViews) {
		this.reqViews = reqViews;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getReqUpdateDate() {
		return reqUpdateDate;
	}

	public void setReqUpdateDate(Date reqUpdateDate) {
		this.reqUpdateDate = reqUpdateDate;
	} 

	
}
