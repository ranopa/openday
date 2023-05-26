package com.kosta.openday.teacher.dto;

public class TeacherFollowDTO {
	private int tchcNum;
	private String tchcNickname;
	private String tchcIntro;
	private String tchcCarrer;
	private int tchcRegistdate;
	private String tchcFollower;
	private int filNum;
	private String userId;
	
	public TeacherFollowDTO() {}
	
	public TeacherFollowDTO(int tchcNum, String tchcNickname, String tchcIntro, String tchcCarrer, 
							 int tchcRegistdate, String tchcFollower, int filNum, String userId) {
		this.tchcNum = tchcNum;
		this.tchcNickname = tchcNickname;
		this.tchcIntro = tchcIntro;
		this.tchcCarrer = tchcCarrer;
		this.tchcRegistdate = tchcRegistdate;
		this.tchcFollower = tchcFollower;
		this.filNum = filNum;
		this.userId = userId;
	}

	public int getTchcNum() {
		return tchcNum;
	}

	public void setTchcNum(int tchcNum) {
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

	public String getTchcCarrer() {
		return tchcCarrer;
	}

	public void setTchcCarrer(String tchcCarrer) {
		this.tchcCarrer = tchcCarrer;
	}

	public int getTchcRegistdate() {
		return tchcRegistdate;
	}

	public void setTchcRegistdate(int tchcRegistdate) {
		this.tchcRegistdate = tchcRegistdate;
	}

	public String getTchcFollower() {
		return tchcFollower;
	}

	public void setTchcFollower(String tchcFollower) {
		this.tchcFollower = tchcFollower;
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
