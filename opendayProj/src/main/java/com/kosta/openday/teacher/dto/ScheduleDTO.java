package com.kosta.openday.teacher.dto;

import java.sql.Date;
import java.sql.Time;

//클래스 일정등록T
public class ScheduleDTO {

	private Integer scdNum; //클래스 일정번호 
	private Date scdDate; //강의일
	private Time scdTime; //소요시간
	private String scdLoc; //장소
	private Integer scdPersonnel; //모집인원

	private Integer scdDiscount; //할인율
	private Date scdUploadDate; //등록일 
	private String scdStatus; //강의상태 
	private Integer clsId; //클래스번호
	
	public ScheduleDTO() {}
	
	public ScheduleDTO(Integer scdNum, Date scdDate, Time scdTime, String scdLoc, Integer scdPersonnel,
			Integer scdDiscount, Date scdUploadDate, String scdStatus, Integer clsId) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdLoc = scdLoc;
		this.scdPersonnel = scdPersonnel;

		this.scdDiscount = scdDiscount;
		this.scdUploadDate = scdUploadDate;
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

	public Integer getScdDiscount() {
		return scdDiscount;
	}

	public void setScdDiscount(Integer scdDiscount) {
		this.scdDiscount = scdDiscount;
	}

	public Date getScdUploadDate() {
		return scdUploadDate;
	}

	public void setScdUploadDate(Date scdUploadDate) {
		this.scdUploadDate = scdUploadDate;
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
