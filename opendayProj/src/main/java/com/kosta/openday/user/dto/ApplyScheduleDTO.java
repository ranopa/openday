package com.kosta.openday.user.dto;

import java.sql.Date;
import java.sql.Time;

public class ApplyScheduleDTO {
	private Integer scdNum;
	private Date scdDate;
	private Time scdTime;
	private String scdPlace;
	private String scdPlaceDetail;
	
	public ApplyScheduleDTO() {}
	
	public ApplyScheduleDTO(Integer scdNum, Date scdDate, Time scdTime, String scdLoc, String scdPlace, String scdPlaceDetail) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdPlace = scdPlace;
		this.scdPlaceDetail = scdPlaceDetail;
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
	
}
