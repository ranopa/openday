package com.kosta.openday.user.dto;

public class PaymentRequestDTO {
	private String userId;
	private Integer clsId;
	private Integer scdNum;
	
	private Integer applyPersonnel;
	private Integer point;
	
	public PaymentRequestDTO() {}
	
	public PaymentRequestDTO(String userId, Integer clsId, Integer scdNum, Integer applyPersonnel, Integer point) {
		this.userId = userId;
		this.clsId = clsId;
		this.scdNum = scdNum;
		this.applyPersonnel = applyPersonnel;
		this.point = point;
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
	
	
}
