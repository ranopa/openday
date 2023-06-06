package com.kosta.openday.adm.dto;

import java.util.List;

import org.springframework.scheduling.annotation.Schedules;

import com.kosta.openday.user.dto.OClassDTO;

public class OClassAndScheduleDTO {
	private Integer clsId;	// 클래스번호
	private String clsName; // 클래스명
	private String clsCode; // 코드(카테고리)
	private String teacherId; 	// 강사아이디  
	private String teacherTel; 	// 강사연락처  
	private String clsCreatedAt; // 등록일 
	private String clsLoc; // 지역 
	private List<Schedules> schedules;
	
	public OClassAndScheduleDTO() {}

	public OClassAndScheduleDTO(Integer clsId, String clsName, String clsCode, String teacherId, String teacherTel,
			String clsCreatedAt, String clsLoc, List<Schedules> schedules) {
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.teacherId = teacherId;
		this.teacherTel = teacherTel;
		this.clsCreatedAt = clsCreatedAt;
		this.clsLoc = clsLoc;
		this.schedules = schedules;
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

	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherTel() {
		return teacherTel;
	}

	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

	public String getClsCreatedAt() {
		return clsCreatedAt;
	}

	public void setClsCreatedAt(String clsCreatedAt) {
		this.clsCreatedAt = clsCreatedAt;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public List<Schedules> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedules> schedules) {
		this.schedules = schedules;
	}

	
	
	
}
