package com.kosta.openday.oclass.dto;

import java.sql.Date;
import java.sql.Time;

public class ScheduleDTO {
	private Integer scdNum;
	private Date scdDate;
	private Time scdTime;
	private String scdLoc;
	private Integer scdPersonnel;
	private Integer scdPrice;
	private Integer scdDiscount;
	private Date scdUploadAt;
	private String scdStatus;
	private Integer clsId;
	
	public ScheduleDTO(Integer scdNum, Date scdDate, Time scdTime, String scdLoc, Integer scdPersonnel,
			Integer scdPrice, Integer scdDiscount, Date scdUploadAt, String scdStatus, Integer clsId) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdLoc = scdLoc;
		this.scdPersonnel = scdPersonnel;
		this.scdPrice = scdPrice;
		this.scdDiscount = scdDiscount;
		this.scdUploadAt = scdUploadAt;
		this.scdStatus = scdStatus;
		this.clsId = clsId;
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

	public String getScdLoc() {
		return scdLoc;
	}

	public void setScdLoc(String scdLoc) {
		this.scdLoc = scdLoc;
	}

	public Integer getScdPersonnel() {
		return scdPersonnel;
	}

	public void setScdPersonnel(Integer scdPersonnel) {
		this.scdPersonnel = scdPersonnel;
	}

	public Integer getScdPrice() {
		return scdPrice;
	}

	public void setScdPrice(Integer scdPrice) {
		this.scdPrice = scdPrice;
	}

	public Integer getScdDiscount() {
		return scdDiscount;
	}

	public void setScdDiscount(Integer scdDiscount) {
		this.scdDiscount = scdDiscount;
	}

	public Date getScdUploadAt() {
		return scdUploadAt;
	}

	public void setScdUploadAt(Date scdUploadAt) {
		this.scdUploadAt = scdUploadAt;
	}

	public String getScdStatus() {
		return scdStatus;
	}

	public void setScdStatus(String scdStatus) {
		this.scdStatus = scdStatus;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}
	
	
	
}
