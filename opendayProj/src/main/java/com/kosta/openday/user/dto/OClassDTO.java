package com.kosta.openday.user.dto;

import java.sql.Date;

public class OClassDTO {
	private Integer clsId;// 클래스번호
	private String clsName; // 클래스명
	private String clsCode; // 코드(카테고리)
	private String clsDescription; // 소개글

	private String clsLoc; // 지역
	private Integer clsDiscount; // 할인율

	private Integer clsPrice; // 클래스 수강료
	private String clsCurri;// 커리큘럼
	private String clsCareer; // 강사 커리어

	private String clsStatus; // 상태 ("승인","승인대기","승인거절")

	private Date clsCreatedAt; // 등록일
	private String clsOpenType; // 개설유형 ("일반","요청");
	private Integer filNum; // 클래스이미지

	private String userId; // 아이디
	private Integer reqId; // 글번호
	

	public OClassDTO() {
	}

	public OClassDTO(Integer clsId, String clsName, String clsCode, String clsDescription, String clsLoc,
			Integer clsDiscount, Integer clsPrice, String clsCurri, String clsCareer, String clsStatus,
			Date clsCreatedAt, String clsOpenType, Integer filNum, String userId, Integer reqId) {
		super();
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.clsDescription = clsDescription;
		this.clsLoc = clsLoc;
		this.clsDiscount = clsDiscount;
		this.clsPrice = clsPrice;
		this.clsCurri = clsCurri;
		this.clsCareer = clsCareer;
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

	public String getClsName() {
		return clsName;
	}

	public String getClsCode() {
		return clsCode;
	}

	public String getClsDescription() {
		return clsDescription;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public Integer getClsDiscount() {
		return clsDiscount;
	}

	public Integer getClsPrice() {
		return clsPrice;
	}

	public String getClsCurri() {
		return clsCurri;
	}

	public String getClsCareer() {
		return clsCareer;
	}

	public String getClsStatus() {
		return clsStatus;
	}

	public Date getClsCreatedAt() {
		return clsCreatedAt;
	}

	public String getClsOpenType() {
		return clsOpenType;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public String getUserId() {
		return userId;
	}

	public Integer getReqId() {
		return reqId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}

	public void setClsDescription(String clsDescription) {
		this.clsDescription = clsDescription;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public void setClsDiscount(Integer clsDiscount) {
		this.clsDiscount = clsDiscount;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}

	public void setClsCurri(String clsCurri) {
		this.clsCurri = clsCurri;
	}

	public void setClsCareer(String clsCareer) {
		this.clsCareer = clsCareer;
	}

	public void setClsStatus(String clsStatus) {
		this.clsStatus = clsStatus;
	}

	public void setClsCreatedAt(Date clsCreatedAt) {
		this.clsCreatedAt = clsCreatedAt;
	}

	public void setClsOpenType(String clsOpenType) {
		this.clsOpenType = clsOpenType;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setReqId(Integer reqId) {
		this.reqId = reqId;
	}

}
