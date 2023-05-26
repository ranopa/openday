package com.kosta.openday.teacher.dto;

public class TeacherChannelDTO {
	private int filNum;
	private String userId;
	
	public TeacherChannelDTO() {}
	
	public TeacherChannelDTO(int filNum, String userId) {
		this.filNum = filNum;
		this.userId = userId;
	}

	public int getFilNum() {
		return filNum;
	}

	public void setFilNum(int filNum) {
		this.filNum = filNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
