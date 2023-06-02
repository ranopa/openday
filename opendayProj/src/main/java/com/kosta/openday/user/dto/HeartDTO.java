package com.kosta.openday.user.dto;
 
//찜
public class HeartDTO {
	private String userId; //유저번호
	private Integer clsId; //클래스번호
	
	public HeartDTO() {}

	public String getUserId() {
		return userId;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public HeartDTO(String userId, Integer clsId) {
		super();
		this.userId = userId;
		this.clsId = clsId;
	}

	
	
	
	
}
