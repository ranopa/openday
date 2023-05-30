package com.kosta.openday.adm.dto;

import java.sql.Date;

//파일
public class FileDTO {
	private Integer filNum; //파일번호
	private String filClassification;//파일분류
	private String filOriginalName; //원본파일명
	private String filSaveName;//저장파일명
	private Integer filSize; //파일용량
	private Date filNewDate; //등록일
	
	public FileDTO() {}
	
	public FileDTO(Integer filNum, String filClassification, String filOriginalName, String filSaveName, Integer filSize,
			Date filNewDate) {
		super();
		this.filNum = filNum;
		this.filClassification = filClassification;
		this.filOriginalName = filOriginalName;
		this.filSaveName = filSaveName;
		this.filSize = filSize;
		this.filNewDate = filNewDate;
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

	public Date getFilNewDate() {
		return filNewDate;
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

	public void setFilNewDate(Date filNewDate) {
		this.filNewDate = filNewDate;
	}
	
	
	 
	
}
