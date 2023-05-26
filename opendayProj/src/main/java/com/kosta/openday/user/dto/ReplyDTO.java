package com.kosta.openday.user.dto;

import java.sql.Date;

//댓글
public class ReplyDTO {
	private Integer reNum; //댓글번호
	private String reTitle; //제목
	private String reContent; //내용
	private Date reDate; //작성일
	private Integer reqId; //글번호
	
	public ReplyDTO() {}

	public ReplyDTO(Integer reNum, String reTitle, String reContent, Date reDate, Integer reqId) {
		super();
		this.reNum = reNum;
		this.reTitle = reTitle;
		this.reContent = reContent;
		this.reDate = reDate;
		this.reqId = reqId;
	}

	public Integer getReNum() {
		return reNum;
	}

	public String getReTitle() {
		return reTitle;
	}

	public String getReContent() {
		return reContent;
	}

	public Date getReDate() {
		return reDate;
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setReNum(Integer reNum) {
		this.reNum = reNum;
	}

	public void setReTitle(String reTitle) {
		this.reTitle = reTitle;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
	}

	public void setReDate(Date reDate) {
		this.reDate = reDate;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	
	
	

}
