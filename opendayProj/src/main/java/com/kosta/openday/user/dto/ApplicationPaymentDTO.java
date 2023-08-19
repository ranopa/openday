package com.kosta.openday.user.dto;

import java.sql.Date;

//클래스 신청&결제 T
public class ApplicationPaymentDTO {
	private Integer apNum; //수강신청번호
	private String apPstatus; //결제상태
	private String apAstatus; //수강상태
	
	private String apPgProvider; // 결제대행
	private String apMethod; //결제방식

	private Integer apFinalAmount; //최종결제금액
	
	// 나중에 Date -> 시,분,초까지 나오는 DateTime으로 바꿔야할듯?
	private Date apDate; //결제일
	private Integer scdNum;//클래스일정번호
	private String userId; //수강생id
	
	public ApplicationPaymentDTO() {}

	public ApplicationPaymentDTO(Integer apNum, String apPstatus, String apAstatus, String apPgProvider, String apMethod,
			Integer apFinalAmount, Date apDate, Integer scdNum, String userId) {
		super();
		this.apNum = apNum;
		this.apPstatus = apPstatus;
		this.apAstatus = apAstatus;
		this.apPgProvider = apPgProvider;
		this.apMethod = apMethod;
		this.apFinalAmount = apFinalAmount;
		this.apDate = apDate;
		this.scdNum = scdNum;
		this.userId = userId;
	}

	public Integer getApNum() {
		return apNum;
	}

	public String getApPstatus() {
		return apPstatus;
	}

	public String getApAstatus() {
		return apAstatus;
	}

	public String getApMethod() {
		return apMethod;
	}

	public Integer getApFinalAmount() {
		return apFinalAmount;
	}

	public Date getApDate() {
		return apDate;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}

	public void setApPstatus(String apPstatus) {
		this.apPstatus = apPstatus;
	}

	public void setApAstatus(String apAstatus) {
		this.apAstatus = apAstatus;
	}

	public void setApMethod(String apMethod) {
		this.apMethod = apMethod;
	}

	public void setApFinalAmount(Integer apFinalAmount) {
		this.apFinalAmount = apFinalAmount;
	}

	public void setApDate(Date apDate) {
		this.apDate = apDate;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getApPgProvider() {
		return apPgProvider;
	}

	public void setApPgProvider(String apPgProvider) {
		this.apPgProvider = apPgProvider;
	}
	
}
