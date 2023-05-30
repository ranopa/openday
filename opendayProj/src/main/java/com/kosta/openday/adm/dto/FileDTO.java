package com.kosta.openday.adm.dto;

import java.sql.Date;

//파일
public class FileDTO {
	private Integer filNum; //파일번호
	private String filClassification;//파일분류
	private String filOrgName; //원본파일명
	private String filSaveName;//저장파일명
	private Long filSize; //파일용량
	private Date filNewDate; //등록일
	
	public FileDTO() {}
	
	public FileDTO(Integer filNum, String filClassification, String filOrgName, String filSaveName, Long filSize,
			Date filNewDate) {
		super();
		this.filNum = filNum;
		this.filClassification = filClassification;
		this.filOrgName = filOrgName;
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

	public String getFilOrgName() {
		return filOrgName;
	}

	public String getFilSaveName() {
		return filSaveName;
	}

	public Long getFilSize() {
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

	public void setFilOrgName(String filOrgName) {
		this.filOrgName = filOrgName;
	}

	public void setFilSaveName(String filSaveName) {
		this.filSaveName = filSaveName;
	}

	public void setFilSize(Long filSize) {
		this.filSize = filSize;
	}

	public void setFilNewDate(Date filNewDate) {
		this.filNewDate = filNewDate;
	}
	
	
	 
	
}
