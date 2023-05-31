package com.kosta.openday.user.dto;

import java.sql.Time;

public class PaymentProcessDTO {
	
	private Integer clsId; // 신청하는 클래스 
	private Integer scdNum; // 신청하는 클래스의 일정 번호 
	private Integer applyPersonnel; // 신청하는 인원 
	private Time selectTime;
	
	public PaymentProcessDTO() {}
	
	public PaymentProcessDTO(Integer clsId, Integer scdNum, Integer applyPersonnel, Time selectTime) {
		this.clsId = clsId;
		this.scdNum = scdNum;
		this.applyPersonnel = applyPersonnel;
		this.selectTime = selectTime;
	}
	
	public Integer getClsId() {
		return clsId;
	}
	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}
	public Integer getScdNum() {
		return scdNum;
	}
	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}
	public Integer getApplyPersonnel() {
		return applyPersonnel;
	}
	public void setApplyPersonnel(Integer applyPersonnel) {
		this.applyPersonnel = applyPersonnel;
	}
	public Time getSelectTime() {
		return selectTime;
	}
	public void setSelectTime(Time selectTime) {
		this.selectTime = selectTime;
	}

	
}
