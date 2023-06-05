package com.kosta.openday.user.dto;

import java.sql.Date;
import java.sql.Time;

import com.kosta.openday.teacher.dto.ScheduleDTO;

public class PaymentProcessResponseDTO {
	private String userId;
	private String userName;
	private String userNickname;
	private String userTel;
	private String userEmail;
	
	private Integer clsId;
	private String clsName;
	
	private Integer scdNum;
	private Date scdDate;
	private Time scdTime;
	// private String scdLoc;
	
	private Integer clsPrice;
	private Integer applyPersonnel;
	
	private Integer totalPrice;
	
	public PaymentProcessResponseDTO(UserDTO user, OClassDTO oClass, ScheduleDTO schedule, Integer applyPersonnel) {
//		this(
//			user.getUserId(),
//			user.getUserName(),
//			user.getUserNickname(),
//			user.getUserTel(),
//			user.getUserEmail(),
//			
//			oClass.getClsId(),
//			oClass.getClsName(),
//			
//			schedule.getScdNum(),
//			schedule.getScdDate(),
//			schedule.getScdTime(),
//			
//			oClass.getClsPrice(),
//			applyPersonnel,
//			oClass.getClsPrice() * applyPersonnel
//		);
	}

	public PaymentProcessResponseDTO(String userId, String userName, String userNickname, String userTel, String userEmail, Integer clsId,
			String clsName, Integer scdNum, Date scdDate, Time scdTime, Integer clsPrice,
			Integer applyPersonnel, Integer totalPrice) {
		this.userId = userId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.clsId = clsId;
		this.clsName = clsName;
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		
		this.clsPrice = clsPrice;
		this.applyPersonnel = applyPersonnel;
		this.totalPrice = totalPrice;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}

	public Date getScdDate() {
		return scdDate;
	}

	public void setScdDate(Date scdDate) {
		this.scdDate = scdDate;
	}

	public Time getScdTime() {
		return scdTime;
	}

	public void setScdTime(Time scdTime) {
		this.scdTime = scdTime;
	}

	

	public Integer getClsPrice() {
		return clsPrice;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}

	public Integer getApplyPersonnel() {
		return applyPersonnel;
	}

	public void setApplyPersonnel(Integer applyPersonnel) {
		this.applyPersonnel = applyPersonnel;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
