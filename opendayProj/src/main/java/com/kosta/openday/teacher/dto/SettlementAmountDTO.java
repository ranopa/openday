package com.kosta.openday.teacher.dto;

import java.sql.Date;

//정산
public class SettlementAmountDTO {
	private Integer saNum; //정산번호 
	private String userId; //강사id
	private Integer saStatus; //정산상태 
	private Date saAppDate; //신청일 
	private Integer saStuNumber; //수강자수
	private Date saSettleDate; //정산일 
	private Integer saPayment; //최종결제금액
	private Integer saSettleAmount; //최종지급금액 
	private Integer saFee; //수수료
	private Integer apNum; //수강신청번호 
	
	public SettlementAmountDTO() {}

	public SettlementAmountDTO(Integer saNum, String userId, Integer saStatus, Date saAppDate, Integer saStuNumber,
			Date saSettleDate, Integer saPayment, Integer saSettleAmount, Integer saFee, Integer apNum) {
		super();
		this.saNum = saNum;
		this.userId = userId;
		this.saStatus = saStatus;
		this.saAppDate = saAppDate;
		this.saStuNumber = saStuNumber;
		this.saSettleDate = saSettleDate;
		this.saPayment = saPayment;
		this.saSettleAmount = saSettleAmount;
		this.saFee = saFee;
		this.apNum = apNum;
	}

	public Integer getSaNum() {
		return saNum;
	}

	public void setSaNum(Integer saNum) {
		this.saNum = saNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getSaStatus() {
		return saStatus;
	}

	public void setSaStatus(Integer saStatus) {
		this.saStatus = saStatus;
	}

	public Date getSaAppDate() {
		return saAppDate;
	}

	public void setSaAppDate(Date saAppDate) {
		this.saAppDate = saAppDate;
	}

	public Integer getSaStuNumber() {
		return saStuNumber;
	}

	public void setSaStuNumber(Integer saStuNumber) {
		this.saStuNumber = saStuNumber;
	}

	public Date getSaSettleDate() {
		return saSettleDate;
	}

	public void setSaSettleDate(Date saSettleDate) {
		this.saSettleDate = saSettleDate;
	}

	public Integer getSaPayment() {
		return saPayment;
	}

	public void setSaPayment(Integer saPayment) {
		this.saPayment = saPayment;
	}

	public Integer getSaSettleAmount() {
		return saSettleAmount;
	}

	public void setSaSettleAmount(Integer saSettleAmount) {
		this.saSettleAmount = saSettleAmount;
	}

	public Integer getSaFee() {
		return saFee;
	}

	public void setSaFee(Integer saFee) {
		this.saFee = saFee;
	}

	public Integer getApNum() {
		return apNum;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}
	
	
	
}
