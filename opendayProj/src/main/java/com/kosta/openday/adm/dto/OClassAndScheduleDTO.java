package com.kosta.openday.adm.dto;

import java.util.List;

import org.springframework.scheduling.annotation.Schedules;

import com.kosta.openday.teacher.dto.ScheduleDTO;

public class OClassAndScheduleDTO {
	private Integer clsId;	// 클래스번호
	private String clsName; // 클래스명
	private String codName; // 코드(카테고리)
	private String teacherId; 	// 강사아이디  
	private String teacherTel; 	// 강사연락처  
	private String clsCreatedAt; // 등록일 
	private String clsLoc; // 지역 
	private List<ScheduleDTO> schedules;
	
	public OClassAndScheduleDTO() {}

	public OClassAndScheduleDTO(Integer clsId, String clsName, String codName, String teacherId, String teacherTel,
			String clsCreatedAt, String clsLoc, List<ScheduleDTO> schedules) {
		super();
		this.clsId = clsId;
		this.clsName = clsName;
		this.codName = codName;
		this.teacherId = teacherId;
		this.teacherTel = teacherTel;
		this.clsCreatedAt = clsCreatedAt;
		this.clsLoc = clsLoc;
		this.schedules = schedules;
	}

	public Integer getClsId() {
		return clsId;
	}

	public String getClsName() {
		return clsName;
	}

	public String getCodName() {
		return codName;
	}

	public String getTeacherId() {
		return teacherId;
	}

	public String getTeacherTel() {
		return teacherTel;
	}

	public String getClsCreatedAt() {
		return clsCreatedAt;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public List<ScheduleDTO> getSchedules() {
		return schedules;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public void setTeacherTel(String teacherTel) {
		this.teacherTel = teacherTel;
	}

	public void setClsCreatedAt(String clsCreatedAt) {
		this.clsCreatedAt = clsCreatedAt;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public void setSchedules(List<ScheduleDTO> schedules) {
		this.schedules = schedules;
	}

	
	
	
}
