package com.kosta.openday.adm.dto;

import java.sql.Date;

//파일
public class FileDTO {
	private Integer filNum; //파일번호
	private String filClassification;//파일분류
	private String filOriginalname; //원본파일명
	private String filSavename;//저장파일명
	private Integer filSize; //파일용량
	private Date filNewDate; //등록일
	
	public FileDTO() {}
	
	public FileDTO(Integer filNum, String filClassification, String filOriginalname, String filSavename, Integer filSize,
			Date filNewDate) {
		super();
		this.filNum = filNum;
		this.filClassification = filClassification;
		this.filOriginalname = filOriginalname;
		this.filSavename = filSavename;
		this.filSize = filSize;
		this.filNewDate = filNewDate;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public String getFilClassification() {
		return filClassification;
	}

	public void setFilClassification(String filClassification) {
		this.filClassification = filClassification;
	}

	public String getFilOriginalname() {
		return filOriginalname;
	}

	public void setFilOriginalname(String filOriginalname) {
		this.filOriginalname = filOriginalname;
	}

	public String getFilSavename() {
		return filSavename;
	}

	public void setFilSavename(String filSavename) {
		this.filSavename = filSavename;
	}

	public Integer getFilSize() {
		return filSize;
	}

	public void setFilSize(Integer filSize) {
		this.filSize = filSize;
	}

	public Date getFilNewDate() {
		return filNewDate;
	}

	public void setFilNewDate(Date filNewDate) {
		this.filNewDate = filNewDate;
	}


	 
	
}
