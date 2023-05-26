package com.kosta.openday.teacher.dto;

import java.sql.Date;
//답변T
public class AnswerDTO {
	private Integer ansNum; //답변번호
	private String ansContent; //답글
	private Date ansDate; //답변일
	private Integer ciNum; //문의번호
	
	public AnswerDTO() {}

	public AnswerDTO(Integer ansNum, String ansContent, Date ansDate, Integer ciNum) {
		super();
		this.ansNum = ansNum;
		this.ansContent = ansContent;
		this.ansDate = ansDate;
		this.ciNum = ciNum;
	}

	public Integer getAnsNum() {
		return ansNum;
	}

	public String getAnsContent() {
		return ansContent;
	}

	public Date getAnsDate() {
		return ansDate;
	}

	public Integer getCiNum() {
		return ciNum;
	}

	public void setAnsNum(Integer ansNum) {
		this.ansNum = ansNum;
	}

	public void setAnsContent(String ansContent) {
		this.ansContent = ansContent;
	}

	public void setAnsDate(Date ansDate) {
		this.ansDate = ansDate;
	}

	public void setCiNum(Integer ciNum) {
		this.ciNum = ciNum;
	}
	
	
	

}
