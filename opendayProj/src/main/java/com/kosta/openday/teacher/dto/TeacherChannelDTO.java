package com.kosta.openday.teacher.dto;

import java.sql.Date;

//강사채널T
public class TeacherChannelDTO {
	
	private Integer tchcNum; //프로필번호	
	private String tchcNickname; //강사닉네임
	private String tchcIntro; //강사소개	
	private String tchcCareer; //경력/이력	
	private Date tchcRegistDate; //등록일	
	private Integer tchcFollower; //팔로워
	private Integer filNum; //강사채널프로필이미지
	private String userId; //아이디	
	
	public TeacherChannelDTO() {}

	public TeacherChannelDTO(Integer tchcNum, String tchcNickname, String tchcIntro, String tchcCareer,
			Date tchcRegistDate, Integer tchcFollower, Integer filNum, String userId) {
		super();
		this.tchcNum = tchcNum;
		this.tchcNickname = tchcNickname;
		this.tchcIntro = tchcIntro;
		this.tchcCareer = tchcCareer;
		this.tchcRegistDate = tchcRegistDate;
		this.tchcFollower = tchcFollower;
		this.filNum = filNum;
		this.userId = userId;
	}

	public Integer getTchcNum() {
		return tchcNum;
	}

	public void setTchcNum(Integer tchcNum) {
		this.tchcNum = tchcNum;
	}

	public String getTchcNickname() {
		return tchcNickname;
	}

	public void setTchcNickname(String tchcNickname) {
		this.tchcNickname = tchcNickname;
	}

	public String getTchcIntro() {
		return tchcIntro;
	}

	public void setTchcIntro(String tchcIntro) {
		this.tchcIntro = tchcIntro;
	}

	public String getTchcCareer() {
		return tchcCareer;
	}

	public void setTchcCareer(String tchcCareer) {
		this.tchcCareer = tchcCareer;
	}

	public Date getTchcRegistDate() {
		return tchcRegistDate;
	}

	public void setTchcRegistDate(Date tchcRegistDate) {
		this.tchcRegistDate = tchcRegistDate;
	}

	public Integer getTchcFollower() {
		return tchcFollower;
	}

	public void setTchcFollower(Integer tchcFollower) {
		this.tchcFollower = tchcFollower;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
