package com.kosta.openday.teacher.dto;

//강사 클래스 일정별 수강생 DTO
public class ClassScdUserDTO {

	private Integer apNum; // 신청번호
	private String userName; // 이름
	private String userTel; // 전화번호
	private String userAddress; // 주소
	private String userEamil; // 이메일
	private String apDate; // 신청일
	
	public ClassScdUserDTO() {}

	public ClassScdUserDTO(Integer apNum, String userName, String userTel, String userAddress, String userEamil,
			String apDate) {
		super();
		this.apNum = apNum;
		this.userName = userName;
		this.userTel = userTel;
		this.userAddress = userAddress;
		this.userEamil = userEamil;
		this.apDate = apDate;
	}

	public Integer getApNum() {
		return apNum;
	}

	public void setApNum(Integer apNum) {
		this.apNum = apNum;
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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEamil() {
		return userEamil;
	}

	public void setUserEamil(String userEamil) {
		this.userEamil = userEamil;
	}

	public String getApDate() {
		return apDate;
	}

	public void setApDate(String apDate) {
		this.apDate = apDate;
	}

	@Override
	public String toString() {
		return "ClassScdUserDTO [apNum=" + apNum + ", userName=" + userName + ", userTel=" + userTel + ", userAddress="
				+ userAddress + ", userEamil=" + userEamil + ", apDate=" + apDate + "]";
	}

	
	
}
