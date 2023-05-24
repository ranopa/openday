package com.kosta.openday.oclass.dto;

import java.util.Date;

public class OclassDTO {
	private Integer clsId;
	private String clsName;
	private String clsCode;
	private String clsDescription;
	private String clsCurri;
	private Integer clsStar;
	private Integer clsHeart;
	private String clsStatus;
	private Date clsCreatedAt;
	private String clsOpenType;
	private Integer filNum;
	private String userId;
	private Integer reqId;
	
	public OclassDTO() {}
	
	public OclassDTO(Integer clsId, String clsName, String clsCode, String clsDescription, String clsCurri,
			Integer clsStar, Integer clsHeart, String clsStatus, Date clsCreatedAt, String clsOpenType, Integer filNum,
			String userId, Integer reqId) {
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.clsDescription = clsDescription;
		this.clsCurri = clsCurri;
		this.clsStar = clsStar;
		this.clsHeart = clsHeart;
		this.clsStatus = clsStatus;
		this.clsCreatedAt = clsCreatedAt;
		this.clsOpenType = clsOpenType;
		this.filNum = filNum;
		this.userId = userId;
		this.reqId = reqId;
	}
	public Integer getClsId() {
		return clsId;
	}
	public void setClsId(Integer clsId) {
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
	public String getClsCurri() {
		return clsCurri;
	}
	public void setClsCurri(String clsCurri) {
		this.clsCurri = clsCurri;
	}
	public Integer getClsStar() {
		return clsStar;
	}
	public void setClsStar(Integer clsStar) {
		this.clsStar = clsStar;
	}
	public Integer getClsHeart() {
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
	public Date getClsCreatedAt() {
		return clsCreatedAt;
	}
	public void setClsCreatedAt(Date clsCreatedAt) {
		this.clsCreatedAt = clsCreatedAt;
	}
	public String getClsOpenType() {
		return clsOpenType;
	}
	public void setClsOpenType(String clsOpenType) {
		this.clsOpenType = clsOpenType;
	}
	public Integer getFilNum() {
		return filNum;
	}
	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getReqId() {
		return reqId;
	}
	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}
	
	
}
