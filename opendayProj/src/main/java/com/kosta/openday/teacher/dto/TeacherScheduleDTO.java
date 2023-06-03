package com.kosta.openday.teacher.dto;

import java.sql.Date;
import java.sql.Time;

public class TeacherScheduleDTO {
	private String clsName; // 클래스명
	private String scdDate; // 강의 일
	private String scdTime; // 강의 시간
	
	public TeacherScheduleDTO() {}

	public TeacherScheduleDTO(String clsName, String scdDate, String scdTime) {
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

	public String getScdDate() {
		return scdDate;
	}

	public void setScdDate(String scdDate) {
		this.scdDate = scdDate;
	}

	public String getScdTime() {
		return scdTime;
	}

	public void setScdTime(String scdTime) {
		this.scdTime = scdTime;
	}

	
	

}
