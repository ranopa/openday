package com.kosta.openday.user.dto;

import java.sql.Date;

//찜
public class HeartDTO {
	private Integer userNum; //유저번호
	private Integer clsId; //클래스번호
	
	public HeartDTO() {}

	public HeartDTO(Integer userNum, Integer clsId) {
		super();
		this.userNum = userNum;
		this.clsId = clsId;
	}

	public Integer getUserNum() {
		return userNum;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setUserNum(Integer userNum) {
		this.userNum = userNum;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}
	
	
	
	
}
