package com.kosta.openday.dtosample;

import java.util.Date;

public class Schedule {
	private Integer scdNum; //클래스 일정번호
	private Date scdDate; //강의일
	private Date scdTime; //시간대
	private String scdLoc; //장소
	private Integer scdPersonnel; //모집인원
	private Integer scdPrice; //수강료
	private Integer scdDiscount; //할인율
	private Date scdUploadDate; //등록일
	private Integer clsId; //클래스번호 
	private String scdStatus; //상태

	public Schedule() {}

	public Schedule(Integer scdNum, Date scdDate, Date scdTime, String scdLoc, Integer scdPersonnel, Integer scdPrice,
			Integer scdDiscount, Date scdUploadDate, Integer clsId, String scdStatus) {
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdLoc = scdLoc;
		this.scdPersonnel = scdPersonnel;
		this.scdPrice = scdPrice;
		this.scdDiscount = scdDiscount;
		this.scdUploadDate = scdUploadDate;
		this.clsId = clsId;
		this.scdStatus = scdStatus;
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

	public Date getScdTime() {
		return scdTime;
	}

	public void setScdTime(Date scdTime) {
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

	public Integer getScdPrice() {
		return scdPrice;
	}

	public void setScdPrice(Integer scdPrice) {
		this.scdPrice = scdPrice;
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

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getScdStatus() {
		return scdStatus;
	}

	public void setScdStatus(String scdStatus) {
		this.scdStatus = scdStatus;
	}
	
	
}
