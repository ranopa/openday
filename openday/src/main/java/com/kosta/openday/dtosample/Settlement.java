package com.kosta.openday.dtosample;

import java.util.Date;

public class Settlement {
	private Integer saNum; // 정산번호
	private String userId; // 강사id
	private String saStatus; // 정산상태
	private Date saAppDate; // 신청일
	private Integer saStuNum; // 수강자수
	private Date saSettleDate; // 정산일
	private Integer saPayment; // 최종결제금액
	private Integer saSattleAmount; // 최종지급금액
	private Integer saFee; // 수수료
	private Integer apNum; // 수강신청번호

	public Settlement() {}

	public Settlement(Integer saNum, String userId, String saStatus, Date saAppDate, Integer saStuNum,
			Date saSettleDate, Integer saPayment, Integer saSattleAmount, Integer saFee, Integer apNum) {
		super();
		this.saNum = saNum;
		this.userId = userId;
		this.saStatus = saStatus;
		this.saAppDate = saAppDate;
		this.saStuNum = saStuNum;
		this.saSettleDate = saSettleDate;
		this.saPayment = saPayment;
		this.saSattleAmount = saSattleAmount;
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

	public String getSaStatus() {
		return saStatus;
	}

	public void setSaStatus(String saStatus) {
		this.saStatus = saStatus;
	}

	public Date getSaAppDate() {
		return saAppDate;
	}

	public void setSaAppDate(Date saAppDate) {
		this.saAppDate = saAppDate;
	}

	public Integer getSaStuNum() {
		return saStuNum;
	}

	public void setSaStuNum(Integer saStuNum) {
		this.saStuNum = saStuNum;
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

	public Integer getSaSattleAmount() {
		return saSattleAmount;
	}

	public void setSaSattleAmount(Integer saSattleAmount) {
		this.saSattleAmount = saSattleAmount;
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
