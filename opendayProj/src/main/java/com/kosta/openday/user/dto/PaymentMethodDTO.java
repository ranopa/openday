package com.kosta.openday.user.dto;

//결제수단
public class PaymentMethodDTO {

	private Integer apNum; // 수강신청번호
	private String pmName; // 결제방식명
	
	public PaymentMethodDTO() {}

	public PaymentMethodDTO(Integer apNum, String pmName) {
		super();
		this.apNum = apNum;
		this.pmName = pmName;
	}

	public Integer getApNum() {
		return apNum;
	}

	public String getPmName() {
		return pmName;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}

	public void setPmName(String pmName) {
		this.pmName = pmName;
	}
	
	
	
	
}
