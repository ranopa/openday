package com.kosta.openday.user.dto;

import java.sql.Date;

public class HeaderSearchFilterDTO {

	private String scdLoc;
	private Date scdDate;
	private String clsCode;
	private Date startDate;
	private Date endDate;
	public HeaderSearchFilterDTO(String scdLoc, Date scdDate, String clsCode, Date startDate, Date endDate) {
		super();
		this.scdLoc = scdLoc;
		this.scdDate = scdDate;
		this.clsCode = clsCode;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public String getScdLoc() {
		return scdLoc;
	}
	public void setScdLoc(String scdLoc) {
		this.scdLoc = scdLoc;
	}
	public Date getScdDate() {
		return scdDate;
	}
	public void setScdDate(Date scdDate) {
		this.scdDate = scdDate;
	}
	public String getClsCode() {
		return clsCode;
	}
	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "HeaderSearchFilterDTO [scdLoc=" + scdLoc + ", scdDate=" + scdDate + ", clsCode=" + clsCode
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
