package com.kosta.openday.dtosample;

import java.util.Date;

public class Application {
	private Integer apNum; //수강신청번호
	private Boolean apPstatus; //결제상태
	private Boolean apAstatus; //수강상태
	private String apMethod; //결제방식
	private Integer apFinalAmount; //최종결제금액
	private Date apDate; //결제일
	private Integer scdNum;//클래스일정번호
	private String userId; //수강생id
	
	public Application() {}

	public Application(Integer apNum, Boolean apPstatus, Boolean apAstatus, String apMethod, Integer apFinalAmount,
			Date apDate, Integer scdNum, String userId) {
		super();
		this.apNum = apNum;
		this.apPstatus = apPstatus;
		this.apAstatus = apAstatus;
		this.apMethod = apMethod;
		this.apFinalAmount = apFinalAmount;
		this.apDate = apDate;
		this.scdNum = scdNum;
		this.userId = userId;
	}

	public Integer getApNum() {
		return apNum;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}

	public Boolean getApPstatus() {
		return apPstatus;
	}

	public void setApPstatus(Boolean apPstatus) {
		this.apPstatus = apPstatus;
	}

	public Boolean getApAstatus() {
		return apAstatus;
	}

	public void setApAstatus(Boolean apAstatus) {
		this.apAstatus = apAstatus;
	}

	public String getApMethod() {
		return apMethod;
	}

	public void setApMethod(String apMethod) {
		this.apMethod = apMethod;
	}

	public Integer getApFinalAmount() {
		return apFinalAmount;
	}

	public void setApFinalAmount(Integer apFinalAmount) {
		this.apFinalAmount = apFinalAmount;
	}

	public Date getApDate() {
		return apDate;
	}

	public void setApDate(Date apDate) {
		this.apDate = apDate;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
