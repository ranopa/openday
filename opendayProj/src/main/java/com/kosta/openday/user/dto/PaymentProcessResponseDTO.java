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
	private Time scdStartTime;

	private String clsLoc;
	private String scdPlace;
	private String scdPlaceDetail;
	
	private Integer clsPrice;
	private Integer clsDiscount;
	
	private Integer applyPersonnel;
	
	private Integer totalPrice;

	public PaymentProcessResponseDTO() {}
	
	public PaymentProcessResponseDTO(UserDTO user, OClassDTO oClass, ScheduleDTO schedule, Integer applyPersonnel) {
		this(
			user.getUserId(),
			user.getUserName(),
			user.getUserNickname(),
			user.getUserTel(),
			user.getUserEmail(),
			
			oClass.getClsId(),
			oClass.getClsName(),
			
			schedule.getScdNum(),
			schedule.getScdDate(),
			schedule.getScdStartTime(),
			
			oClass.getClsLoc(),
			schedule.getScdPlace(),
			schedule.getScdPlaceDetail(),
			
			oClass.getClsPrice(),
			oClass.getClsDiscount(),
			applyPersonnel,
			oClass.getClsPrice() * applyPersonnel
		);
	}

	public PaymentProcessResponseDTO(String userId, String userName, String userNickname, String userTel,
			String userEmail, Integer clsId, String clsName, Integer scdNum, Date scdDate, Time scdTime, String clsLoc,
			String scdPlace, String scdPlaceDetail, Integer clsPrice, Integer clsDiscount, Integer applyPersonnel, Integer totalPrice) {
		this.userId = userId;
		this.userName = userName;
		this.userNickname = userNickname;
		this.userTel = userTel;
		this.userEmail = userEmail;
		this.clsId = clsId;
		this.clsName = clsName;
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdStartTime = scdStartTime;
		this.clsLoc = clsLoc;
		this.scdPlace = scdPlace;
		this.scdPlaceDetail = scdPlaceDetail;
		this.clsPrice = clsPrice;
		this.clsDiscount = clsDiscount;
		this.applyPersonnel = applyPersonnel;
		this.totalPrice = totalPrice;
	}

	public Integer getClsDiscount() {
		return clsDiscount;
	}

	public void setClsDiscount(Integer clsDiscount) {
		this.clsDiscount = clsDiscount;
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

	public Time getScdStartTime() {
		return scdStartTime;
	}

	public void setScdStartTime(Time scdStartTime) {
		this.scdStartTime = scdStartTime;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public String getScdPlace() {
		return scdPlace;
	}

	public void setScdPlace(String scdPlace) {
		this.scdPlace = scdPlace;
	}

	public String getScdPlaceDetail() {
		return scdPlaceDetail;
	}

	public void setScdPlaceDetail(String scdPlaceDetail) {
		this.scdPlaceDetail = scdPlaceDetail;
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
