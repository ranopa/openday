package com.kosta.openday.user.dto;

import java.sql.Date;

import com.kosta.openday.teacher.dto.ScheduleDTO;

public class PaymentResultDTO {
	private Integer apNum; //수강신청번호
	private String apPstatus; //결제상태
	private String apMethod; //결제방식
	
	// todo: 단순 최종금액이 아니라, 적용한 할인정보까지 포함해서
	private Integer apFinalAmount; //최종결제금액
	private Date apDate; //결제일
	private OClassDTO oClass;
	private ScheduleDTO schedule;
	private String userId; //수강생id

	public PaymentResultDTO() {}

	public PaymentResultDTO(Integer apNum, String apPstatus, String apMethod, Integer apFinalAmount, Date apDate,
			OClassDTO oClass, ScheduleDTO schedule, String userId) {
		this.apNum = apNum;
		this.apPstatus = apPstatus;
		this.apMethod = apMethod;
		this.apFinalAmount = apFinalAmount;
		this.apDate = apDate;
		this.oClass = oClass;
		this.schedule = schedule;
		this.userId = userId;
	}

	public Integer getApNum() {
		return apNum;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}

	public String getApPstatus() {
		return apPstatus;
	}

	public void setApPstatus(String apPstatus) {
		this.apPstatus = apPstatus;
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

	public OClassDTO getoClass() {
		return oClass;
	}

	public void setoClass(OClassDTO oClass) {
		this.oClass = oClass;
	}

	public ScheduleDTO getSchedule() {
		return schedule;
	}

	public void setSchedule(ScheduleDTO schedule) {
		this.schedule = schedule;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
