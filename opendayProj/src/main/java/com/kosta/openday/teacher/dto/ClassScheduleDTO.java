package com.kosta.openday.teacher.dto;

import java.sql.Date;

//클래스 일정등록T
public class ClassScheduleDTO {

	private Integer scdNum; // 클래스 일정번호
	private String clsName; // 강의 시간
	private String scdStartTime; // 강의 시간
	private String scdPlaceDetail; // 장소
	private Integer scdApCount; // 신청인원
	private Integer scdMinPersonnel; // 최대수강인원
	private Integer scdMaxPersonnel; // 최소수강인원
	private String scdPrice; // 최종수강료(할인적용)
	private Date scdUploadDate; // 등록일

	public ClassScheduleDTO() {
	}

	public ClassScheduleDTO(Integer scdNum, String clsName, String scdStartTime, String scdPlaceDetail,
			Integer scdApCount, Integer scdMinPersonnel, Integer scdMaxPersonnel, String scdPrice, Date scdUploadDate) {
		super();
		this.scdNum = scdNum;
		this.clsName = clsName;
		this.scdStartTime = scdStartTime;
		this.scdPlaceDetail = scdPlaceDetail;
		this.scdApCount = scdApCount;
		this.scdMinPersonnel = scdMinPersonnel;
		this.scdMaxPersonnel = scdMaxPersonnel;
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

	public String getScdStartTime() {
		return scdStartTime;
	}

	public void setScdStartTime(String scdStartTime) {
		this.scdStartTime = scdStartTime;
	}

	public String getScdPlaceDetail() {
		return scdPlaceDetail;
	}

	public void setScdPlaceDetail(String scdPlaceDetail) {
		this.scdPlaceDetail = scdPlaceDetail;
	}

	public Integer getScdApCount() {
		return scdApCount;
	}

	public void setScdApCount(Integer scdApCount) {
		this.scdApCount = scdApCount;
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
