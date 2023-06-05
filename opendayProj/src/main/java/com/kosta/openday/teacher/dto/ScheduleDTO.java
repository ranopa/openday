package com.kosta.openday.teacher.dto;

import java.sql.Date;
import java.sql.Time;

//클래스 일정등록T
public class ScheduleDTO {

	private Integer scdNum; //클래스 일정번호 
	private Date scdDate; //강의일
	private Time scdTime; //소요시간
	private String scdPlace; //장소
	private String scdPlaceDetail; //세부장소
	private Integer scdPersonnel; //모집인원
 
	private Date scdUploadDate; //등록일 
	private String scdStatus; //강의상태 (예정/폐강/완료)
	private Integer clsId; //클래스번호
	
	public ScheduleDTO() {}

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

	public Integer getScdPersonnel() {
		return scdPersonnel;
	}

	public void setScdPersonnel(Integer scdPersonnel) {
		this.scdPersonnel = scdPersonnel;
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

	public ScheduleDTO(Integer scdNum, Date scdDate, Time scdTime, String scdPlace, String scdPlaceDetail,
			Integer scdPersonnel, Date scdUploadDate, String scdStatus, Integer clsId) {
		super();
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdPlace = scdPlace;
		this.scdPlaceDetail = scdPlaceDetail;
		this.scdPersonnel = scdPersonnel;
		this.scdUploadDate = scdUploadDate;
		this.scdStatus = scdStatus;
		this.clsId = clsId;
	}

	
	
}
