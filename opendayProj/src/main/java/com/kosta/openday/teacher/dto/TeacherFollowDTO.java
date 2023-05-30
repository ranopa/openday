package com.kosta.openday.teacher.dto;

//강사팔로우
public class TeacherFollowDTO {

	private Integer tchfNum; //프로필번호
	private String userId; //유저아이디
	
	public TeacherFollowDTO() {}

	public TeacherFollowDTO(Integer tchfNum, String userId) {
		super();
		this.tchfNum = tchfNum;
		this.userId = userId;
	}

	public Integer getTchfNum() {
		return tchfNum;
	}

	public void setTchfNum(Integer tchfNum) {
		this.tchfNum = tchfNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
