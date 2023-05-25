package com.kosta.openday.user.dto;

import java.sql.Date;

public class FileDTO {
	private Integer filNum;
	private String filClassification;
	private String filOriginalName;
	private String filSaveName;
	private Integer filSize;
	private Date filNewdate;
	
	public FileDTO(Integer filNum, String filClassification, String filOriginalName, String filSaveName,
			Integer filSize) {
		super();
		this.filNum = filNum;
		this.filClassification = filClassification;
		this.filOriginalName = filOriginalName;
		this.filSaveName = filSaveName;
		this.filSize = filSize;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public String getFilClassification() {
		return filClassification;
	}

	public String getFilOriginalName() {
		return filOriginalName;
	}

	public String getFilSaveName() {
		return filSaveName;
	}

	public Integer getFilSize() {
		return filSize;
	}

	public Date getFilNewdate() {
		return filNewdate;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public void setFilClassification(String filClassification) {
		this.filClassification = filClassification;
	}

	public void setFilOriginalName(String filOriginalName) {
		this.filOriginalName = filOriginalName;
	}

	public void setFilSaveName(String filSaveName) {
		this.filSaveName = filSaveName;
	}

	public void setFilSize(Integer filSize) {
		this.filSize = filSize;
	}

	public void setFilNewdate(Date filNewdate) {
		this.filNewdate = filNewdate;
	}
	
	
	
}
