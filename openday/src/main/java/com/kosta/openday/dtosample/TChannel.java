package com.kosta.openday.dtosample;

import java.util.Date;

public class TChannel {
	private Integer tchcNum; //프로필번호
	private String userId; //강사아이디
	private String tchcNickname; //강사닉네임
	private String tchcIntro; //강사소개
	private String tchcCareer; //경력/이력
	private Date tchcRegistDate; //등록일
 	private String tchcFollower; //팔로워
	private String fileNum; //프로필 파일번호
	
	public TChannel() {}

	public TChannel(Integer tchcNum, String userId, String tchcNickname, String tchcIntro, String tchcCareer,
			Date tchcRegistDate, String tchcFollower, String fileNum) {
		super();
		this.tchcNum = tchcNum;
		this.userId = userId;
		this.tchcNickname = tchcNickname;
		this.tchcIntro = tchcIntro;
		this.tchcCareer = tchcCareer;
		this.tchcRegistDate = tchcRegistDate;
		this.tchcFollower = tchcFollower;
		this.fileNum = fileNum;
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

	public String getTchcFollower() {
		return tchcFollower;
	}

	public void setTchcFollower(String tchcFollower) {
		this.tchcFollower = tchcFollower;
	}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	
	
	
}
