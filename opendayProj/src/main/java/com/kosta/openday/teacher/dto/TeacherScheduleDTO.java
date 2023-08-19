package com.kosta.openday.teacher.dto;

public class TeacherScheduleDTO {
	private String clsName; // 클래스명
	private String scdDate; // 강의 일
	private String scdStartTime; // 강의 시간
	
	public TeacherScheduleDTO() {}

	public TeacherScheduleDTO(String clsName, String scdDate, String scdStartTime) {
		super();
		this.clsName = clsName;
		this.scdDate = scdDate;
		this.scdStartTime = scdStartTime;
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

	public String getscdStartTime() {
		return scdStartTime;
	}

	public void setscdStartTime(String scdStartTime) {
		this.scdStartTime = scdStartTime;
	}

	
	

}
