package com.kosta.openday.user.dto;

public class PaymentRequestDTO {
	private String userId;
	private Integer clsId;
	private Integer scdNum;
	
	private Integer applyPersonnel;
	private Integer point;
	
	private String pgProvider;
	private String paymentMethod;
	
	public PaymentRequestDTO() { }
	
	public PaymentRequestDTO(String userId, Integer clsId, Integer scdNum, Integer applyPersonnel, Integer point, String pgProvider, String paymentMethod) {
		this.userId = userId;
		this.clsId = clsId;
		this.scdNum = scdNum;
		this.applyPersonnel = applyPersonnel;
		this.point = point;
		this.pgProvider = pgProvider;
		this.paymentMethod = paymentMethod;
	}

	public String getPgProvider() {
		return pgProvider;
	}

	public void setPgProvider(String pgProvider) {
		this.pgProvider = pgProvider;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	
	public String getPaymentMethodName() {
		if (this.paymentMethod.equals("point"))
			return "포인트";
		return "카드";
	} 
	
	
}
