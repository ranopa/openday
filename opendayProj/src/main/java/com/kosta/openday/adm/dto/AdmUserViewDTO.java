package com.kosta.openday.adm.dto;

import java.sql.Date;

public class AdmUserViewDTO {
	private String userId;
	private String userNickname;
	private String userName;
	private String userTel;
	private String userEmail;
	private String userAccount;
	private Date userJoindate;
	
	private Integer tchcNum;
	private String tchcNickname;
	private Date tchcRegistDate;
	
	public AdmUserViewDTO() {}
	
	public AdmUserViewDTO(String userId, String userNickname, String userName, String userTel, String userEmail,
			String userAccount, Date userJoindate, Integer tchcNum, String tchcNickname, Date tchcRegistDate) {
		this.userId = userId;
		this.userNickname = userNickname;
		this.userName = userName;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.userAccount = userAccount;
		this.userJoindate = userJoindate;
		this.tchcNum = tchcNum;
		this.tchcNickname = tchcNickname;
		this.tchcRegistDate = tchcRegistDate;
	}



	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNickname() {
		return userNickname;
	}
	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public Date getUserJoindate() {
		return userJoindate;
	}
	public void setUserJoindate(Date userJoindate) {
		this.userJoindate = userJoindate;
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
	public Date getTchcRegistDate() {
		return tchcRegistDate;
	}
	public void setTchcRegistDate(Date tchcRegistDate) {
		this.tchcRegistDate = tchcRegistDate;
	}
	
	
	
}
