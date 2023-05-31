package com.kosta.openday.user.dto;

import java.sql.Date;

public class UserDTO {
	private String userId; //아이디
	private String userPassword; //비밀번호
	private String userName; //이름
	private String userNickname; //별명 	
	private String userTel; //번호
	private String userAddress; //주소
	private String emailVal; //입력이메일  
	private String domain; //도메인
	private String userEmail;//입력이메일 + 도메인 
	private String birthVal; //생일
	private Date userBirth; //생일
	private String userActive; //활성화
	private Integer userAccount; //계좌번호
	private String userAlarm; //알림여부
	private Date userJoindate; //가입일
	private String userPrefer; //선호카테고리
	private String authority; //권한
	private Integer userFilenum; //파일번호
	
	public UserDTO() {}

	public UserDTO(String userId, String userPassword, String userName, String userNickname, String userTel,
			String userAddress, String emailVal, String domain, String birthVal) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.emailVal = emailVal;
		this.domain = domain;
		this.birthVal = birthVal;
	}

	public UserDTO(String userId, String userPassword, String userName, String userNickname, String userTel,
			String userAddress, String emailVal, String domain, String userEmail, String birthVal, Date userBirth,
			String userActive, Integer userAccount, String userAlarm, Date userJoindate, String userPrefer,
			String authority, Integer userFilenum) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.emailVal = emailVal;
		this.domain = domain;
		this.userEmail = userEmail;
		this.birthVal = birthVal;
		this.userBirth = userBirth;
		this.userActive = userActive;
		this.userAccount = userAccount;
		this.userAlarm = userAlarm;
		this.userJoindate = userJoindate;
		this.userPrefer = userPrefer;
		this.authority = authority;
		this.userFilenum = userFilenum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getEmailVal() {
		return emailVal;
	}

	public void setEmailVal(String emailVal) {
		this.emailVal = emailVal;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getBirthVal() {
		return birthVal;
	}

	public void setBirthVal(String birthVal) {
		this.birthVal = birthVal;
	}

	public Date getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(Date userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserActive() {
		return userActive;
	}

	public void setUserActive(String userActive) {
		this.userActive = userActive;
	}

	public Integer getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Integer userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserAlarm() {
		return userAlarm;
	}

	public void setUserAlarm(String userAlarm) {
		this.userAlarm = userAlarm;
	}

	public Date getUserJoindate() {
		return userJoindate;
	}

	public void setUserJoindate(Date userJoindate) {
		this.userJoindate = userJoindate;
	}

	public String getUserPrefer() {
		return userPrefer;
	}

	public void setUserPrefer(String userPrefer) {
		this.userPrefer = userPrefer;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Integer getUserFilenum() {
		return userFilenum;
	}

	public void setUserFilenum(Integer userFilenum) {
		this.userFilenum = userFilenum;
	}
	
}

