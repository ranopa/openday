package com.kosta.openday.user.dto;

import java.sql.Date;
import java.sql.Time;

public class ClassScheduleDTO {
	private String clsName; // 클래스명
	private Date scdDate; // 강의 일
	private Time scdTime; // 강의 시간
	
	public ClassScheduleDTO() {}

	public ClassScheduleDTO(String clsName, Date scdDate, Time scdTime) {
		super();
		this.clsName = clsName;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
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
	
	
	

}
