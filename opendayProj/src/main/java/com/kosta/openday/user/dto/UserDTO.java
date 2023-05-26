package com.kosta.openday.user.dto;

public class UserDTO {
	private String userId;
	private String userPassword;
	private String userName;
	private String userNickname;
	private String userTel;
	private String userAddress;
	private String userEmail;
	private int userBirth;
	private String userActivation;
	private String userAccount;
	private String userAlarm;
	private int userJoindate;
	private String userPreference;
	private String authority;
	private int filNum;
	
	public UserDTO(){}
	
	public UserDTO(String userId, String userPassword, String userName, String userNickname, String userTel,
				   String userAddress, String userEmail, int userBirth, String userActivation, String userAccount,
				   String userAlarm, int userJoindate, String userPreference, String authority, int filNum) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userEmail = userEmail;
		this.userBirth = userBirth;
		this.userActivation = userActivation;
		this.userAccount = userAccount;
		this.userAlarm = userAlarm;
		this.userJoindate = userJoindate;
		this.authority = authority;
		this.filNum = filNum;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(int userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserActivation() {
		return userActivation;
	}

	public void setUserActivation(String userActivation) {
		this.userActivation = userActivation;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserAlarm() {
		return userAlarm;
	}

	public void setUserAlarm(String userAlarm) {
		this.userAlarm = userAlarm;
	}

	public int getUserJoindate() {
		return userJoindate;
	}

	public void setUserJoindate(int userJoindate) {
		this.userJoindate = userJoindate;
	}

	public String getUserPreference() {
		return userPreference;
	}

	public void setUserPreference(String userPreference) {
		this.userPreference = userPreference;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getFilNum() {
		return filNum;
	}

	public void setFilNum(int filNum) {
		this.filNum = filNum;
	}
	
	
}
