package com.kosta.openday.teacher.dto;

//강사팔로우
public class TeacherFollowDTO {

	private Integer tchcNum; //프로필번호
	private String userId; //유저아이디
	
	public TeacherFollowDTO() {}

	public TeacherFollowDTO(Integer tchcNum, String userId) {
		super();
		this.tchcNum = tchcNum;
		this.userId = userId;
	}

	public Integer getTchcNum() {
		return tchcNum;
	}

	public void setTchcNum(Integer tchcNum) {
		this.tchcNum = tchcNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
