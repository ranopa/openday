package com.kosta.openday.teacher.dto;

import java.sql.Date;

//클래스 일정등록T
public class ClassScheduleDTO {

	private Integer scdNum; // 클래스 일정번호
	private String clsName; // 강의 시간
	private String scdTime; // 강의 시간
	private String scdLoc; // 장소
	private Integer scdPersonnel; // 모집인원
	private String scdPrice; // 최종수강료(할인적용)
	private Date scdUploadDate; // 등록일

	public ClassScheduleDTO() {
	}

	public ClassScheduleDTO(Integer scdNum, String clsName, String scdTime, String scdLoc, Integer scdPersonnel,
			String scdPrice, Date scdUploadDate) {
		super();
		this.scdNum = scdNum;
		this.clsName = clsName;
		this.scdTime = scdTime;
		this.scdLoc = scdLoc;
		this.scdPersonnel = scdPersonnel;
		this.scdPrice = scdPrice;
		this.scdUploadDate = scdUploadDate;
	}

	public Integer getScdNum() {
		return scdNum;
	}

	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getScdTime() {
		return scdTime;
	}

	public void setScdTime(String scdTime) {
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

	public String getScdPrice() {
		return scdPrice;
	}

	public void setScdPrice(String scdPrice) {
		this.scdPrice = scdPrice;
	}

	public Date getScdUploadDate() {
		return scdUploadDate;
	}

	public void setScdUploadDate(Date scdUploadDate) {
		this.scdUploadDate = scdUploadDate;
	}


	

}
