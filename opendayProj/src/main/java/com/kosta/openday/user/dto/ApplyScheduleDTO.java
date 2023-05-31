package com.kosta.openday.user.dto;

import java.sql.Date;
import java.sql.Time;

public class ApplyScheduleDTO {
	private Integer scdNum;
	private Date scdDate;
	private Time scdTime;
	private String scdLoc;
	private String scdPlace;
	
	public ApplyScheduleDTO() {}
	
	public ApplyScheduleDTO(Integer scdNum, Date scdDate, Time scdTime, String scdLoc, String scdPlace) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdLoc = scdLoc;
		this.scdPlace = scdPlace;
	}

	public Integer getScdNum() {
		return scdNum;
	}
	public Date getScdDate() {
		return scdDate;
	}
	public Time getScdTime() {
		return scdTime;
	}
	public String getScdLoc() {
		return scdLoc;
	}
	public String getScdPlace() {
		return scdPlace;
	}
	
	
}
