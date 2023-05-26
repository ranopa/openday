package com.kosta.openday.oclass.dto;

public class OclassDTO {
	private int clsId;
	private String clsName;
	private String clsCode;
	private String clsDescription;
	private String clsCarrer;
	private String clsCurri;
	private int clsStar;
	private int clsHeart;
	private String clsStatus;
	private String clsCreatedAt;

	private String clsOpenType;
	private int fileId;
	
	public OclassDTO() {}
	
	public OclassDTO(int clsId, String clsName, String clsDescription, String Carrer, String clsCurri, int clsStar, int clsHeart, 
					String clsStatus, String clsCreatedAt, String clsOpenType, int fileId) {
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsDescription = clsDescription;
		this.clsCarrer = clsCarrer;
		this.clsCurri = clsCurri;
		this.clsStar = clsStar;
		this.clsHeart = clsHeart;
		this.clsStatus = clsStatus;
		this.clsCreatedAt = clsCreatedAt;
		this.clsOpenType = clsOpenType;
	}

	public int getClsId() {
		return clsId;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getClsCode() {
		return clsCode;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public String getClsDescription() {
		return clsDescription;
	}

	public void setClsDescription(String clsDescription) {
		this.clsDescription = clsDescription;
	}
	
	public String getClsCarrer() {
		return clsCarrer;
	}

	public void setClsCarrer(String clsCarrer) {
		this.clsCarrer = clsCarrer;
	}

	public String getClsCurri() {
		return clsCurri;
	}

	public void setClsCurri(String clsCurri) {
		this.clsCurri = clsCurri;
	}

	public int getClsStar() {
		return clsStar;
	}

	public void setClsStar(Integer clsStar) {
		this.clsStar = clsStar;
	}

	public int getClsHeart() {
		return clsHeart;
	}

	public void setClsHeart(Integer clsHeart) {
		this.clsHeart = clsHeart;
	}

	public String getClsStatus() {
		return clsStatus;
	}

	public void setClsStatus(String clsStatus) {
		this.clsStatus = clsStatus;
	}

	public String getClsCreatedAt() {
		return clsCreatedAt;
	}

	public void setClsCreatedAt(String clsCreatedAt) {
		this.clsCreatedAt = clsCreatedAt;
	}

	public String getClsOpenType() {
		return clsOpenType;
	}

	public void setClsOpenType(String clsOpenType) {
		this.clsOpenType = clsOpenType;
	}
	
	public Integer getFileId() {
		return fileId;
	}
	
	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}
}
