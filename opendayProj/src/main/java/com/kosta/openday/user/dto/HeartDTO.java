package com.kosta.openday.user.dto;
 
//찜
public class HeartDTO {
	private String userId; //유저번호
	private Integer scdNum; //클래스번호
	
	public HeartDTO() {}

	public HeartDTO(String userId, Integer scdNum) {
		super();
		this.userId = userId;
		this.scdNum = scdNum;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}
	
	
	
	
}
