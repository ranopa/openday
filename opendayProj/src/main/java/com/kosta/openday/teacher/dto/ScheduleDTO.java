package com.kosta.openday.teacher.dto;

import java.sql.Date;
import java.sql.Time;

//클래스 일정등록T
public class ScheduleDTO {

	private Integer scdNum; //클래스 일정번호 
	private Date scdDate; //강의일
	private Integer scdRunTime; //소요시간
	private Time scdStartTime; //클래스 시작 시간
	private Time scdEndTime; //클래스 끝 시간
	private String scdPlace; //장소
	private String scdPlaceDetail; //세부장소
	private Integer scdMinPersonnel; //모집인원
	private Integer scdMaxPersonnel; //모집인원
	private Date scdUploadDate; //등록일 
	private String scdStatus; //강의상태 (예정/폐강/완료)
	private Integer clsId; //클래스번호
	
	public ScheduleDTO() {}

	public ScheduleDTO(Integer scdNum, Date scdDate, Integer scdRunTime,Time scdStartTime, Time scdEndTime, String scdPlace, 
			String scdPlaceDetail,Integer scdMinPersonnel, Integer scdMaxPersonnel, Date scdUploadDate, String scdStatus, Integer clsId) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdRunTime = scdRunTime;
		this.scdStartTime = scdStartTime;
		this.scdEndTime = scdEndTime;
		this.scdPlace = scdPlace;
		this.scdPlaceDetail = scdPlaceDetail;
		this.scdMinPersonnel = scdMinPersonnel;
		this.scdMaxPersonnel = scdMaxPersonnel;
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

	public Integer getScdRunTime() {
		return scdRunTime;
	}

	public void setScdRunTime(Integer scdRunTime) {
		this.scdRunTime = scdRunTime;
	}

	public Time getScdStartTime() {
		return scdStartTime;
	}

	public void setScdStartTime(Time scdStartTime) {
		this.scdStartTime = scdStartTime;
	}

	public Time getScdEndTime() {
		return scdEndTime;
	}

	public void setScdEndTime(Time scdEndTime) {
		this.scdEndTime = scdEndTime;
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

	public Integer getScdMinPersonnel() {
		return scdMinPersonnel;
	}

	public void setScdMinPersonnel(Integer scdMinPersonnel) {
		this.scdMinPersonnel = scdMinPersonnel;
	}

	public Integer getScdMaxPersonnel() {
		return scdMaxPersonnel;
	}

	public void setScdMaxPersonnel(Integer scdMaxPersonnel) {
		this.scdMaxPersonnel = scdMaxPersonnel;
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

	public void setScdDate(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setScdStartTime(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setScdEndTime(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setStart(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setTitle(Object title) {
		// TODO Auto-generated method stub
		
	}

	public Object getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEnd(String string) {
		// TODO Auto-generated method stub
		
	}


}
