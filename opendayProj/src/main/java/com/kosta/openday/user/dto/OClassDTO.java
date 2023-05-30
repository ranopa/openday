package com.kosta.openday.user.dto;

import java.sql.Date;

public class OClassDTO {
	private Integer clsId;// 클래스번호 
	private String clsName; // 클래스명
	private String clsCode; // 코드(카테고리)
	private String clsDescription; // 소개글
	private String clsCurri;// 커리큘럼
	private String clsCareer;// 강사,강의 경력
	private Integer clsStar; // 별점
	private Integer clsHeart; // 하트수
	private String clsStatus; // 상태
	private Date clsCreatedAt; // 등록일
	private String clsOpenType; // 개설유형
	private Integer filNum; // 클래스이미지 	
	private String userId; // 아이디
	private Integer reqId; // 글번호

	public OClassDTO() {}

	public OClassDTO(Integer clsId, String clsName, String clsCode, String clsDescription, String clsCurri, String clsCarrer,
			Integer clsStar, Integer clsHeart, String clsStatus, Date clsCreatedAt, String clsOpenType, Integer filNum,
			String userId, Integer reqId) {
		super();
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.clsDescription = clsDescription;
		this.clsCurri = clsCurri;
		this.clsCareer = clsCarrer;
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

	public String getClsCareer() {
		return clsCareer;
	}

	public void setClsCareer(String clsCareer) {
		this.clsCareer = clsCareer;
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
