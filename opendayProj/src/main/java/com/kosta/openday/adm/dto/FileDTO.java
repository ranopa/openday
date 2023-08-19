package com.kosta.openday.adm.dto;

import java.sql.Date;

//파일
public class FileDTO {
	private Integer filNum; //파일번호
	private String filClassification;//파일분류
	private String filOriginalname; //원본파일명
	private String filSavename;//저장파일명
	private Long filSize; //파일용량
	private Date filNewdate; //등록일
	
	public FileDTO() {}

	public FileDTO(Integer filNum, String filClassification, String filOriginalname, String filSavename, Long filSize,
			Date filNewdate) {
	public FileDTO(Integer filNum, String filClassification, String filOrgName, String filSaveName, Long filSize,
			Date filNewDate) {
		super();
		this.filNum = filNum;
		this.filClassification = filClassification;
		this.filOriginalname = filOriginalname;
		this.filSavename = filSavename;
		this.filSize = filSize;
		this.filNewdate = filNewdate;
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

	public void setFilOrginalname(String filOriginalname) {
		this.filOriginalname = filOriginalname;
	}

	public String getFilSavename() {
		return filSavename;
	}

	public void setFilSavename(String filSavename) {
		this.filSavename = filSavename;
	}

	public Long getFilSize() {
		return filSize;
	}
=======
	}

	public String getFilClassification() {
		return filClassification;
	}

	public void setFilClassification(String filClassification) {
		this.filClassification = filClassification;
	}

	public String getFilOrgName() {
		return filOrgName;
	}

	public void setFilOrgName(String filOrgName) {
		this.filOrgName = filOrgName;
	}

	public String getFilSaveName() {
		return filSaveName;
	}

	public void setFilSaveName(String filSaveName) {
		this.filSaveName = filSaveName;
	}

	public Long getFilSize() {
		return filSize;
	}

	public void setFilSize(Long filSize) {
		this.filSize = filSize;
	}

	public Date getFilNewDate() {
		return filNewDate;
	}

	public void setFilNewDate(Date filNewDate) {
		this.filNewDate = filNewDate;
	}

  
	public Date getFilNewdate() {
		return filNewdate;
	}

	public void setFilNewdate(Date filNewdate) {
		this.filNewdate = filNewdate;
	}
	
	
}
