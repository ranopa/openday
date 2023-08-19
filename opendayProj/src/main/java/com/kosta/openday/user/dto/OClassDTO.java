package com.kosta.openday.user.dto;

import java.sql.Date;


public class OClassDTO {
	private Integer clsId;// 클래스번호
	private String clsName; // 클래스명
	private String clsCode; // 코드(카테고리)
	private String clsDescription; // 소개글

	private Integer clsPrice; // 클래스 수강료
	private String clsCurri;// 커리큘럼

	private String clsCareer; // 강사 커리어
	private String clsStatus; // 상태 ("승인","승인대기","승인거절")
	
	private String clsLoc; // 지역
	private Integer clsDiscount; // 할인율
	
	private Date clsCreatedAt; // 등록일
	private String clsOpenType; // 개설유형 ("일반","요청");
	private Integer filNum; // 클래스이미지

	private String userId; // 아이디
	private Integer reqId; // 글번호
	
	private Integer clsInquiry; // 문의 갯수
	
	private Integer totPrice; // 클래스 결제 통합 금액
	private Integer amountPaid; // 클래스 지급 금액
	private Integer amountOutstanding; // 클래스 미지급 금액
	private double rvStar;
	private int heartCount;
	
	private Integer  saFee;
	public OClassDTO() {
	}


	public OClassDTO(Integer clsId, String clsName, String clsCode, String clsDescription, String clsLoc,
			Integer clsDiscount, Integer clsPrice, String clsCurri,
			String clsCareer, String clsStatus, Date clsCreatedAt, String clsOpenType, Integer filNum, String userId,
			Integer reqId) {
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


	public Integer getClsPrice() {
		return clsPrice;
	}


	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
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


	public String getClsStatus() {
		return clsStatus;
	}


	public void setClsStatus(String clsStatus) {
		this.clsStatus = clsStatus;
	}


	public String getClsLoc() {
		return clsLoc;
	}


	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}


	public Integer getClsDiscount() {
		return clsDiscount;
	}


	public void setClsDiscount(Integer clsDiscount) {
		this.clsDiscount = clsDiscount;
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


	public Integer getClsInquiry() {
		return clsInquiry;
	}


	public void setClsInquiry(Integer clsInquiry) {
		this.clsInquiry = clsInquiry;
	}



	public Integer getTotPrice() {
		return totPrice;
	}


	public void setTotPrice(Integer totPrice) {
		this.totPrice = totPrice;
	}


	public Integer getAmountPaid() {
		return amountPaid;
	}


	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}


	public Integer getAmountOutstanding() {
		return amountOutstanding;
	}


	public void setAmountOutstanding(Integer amountOutstanding) {
		this.amountOutstanding = amountOutstanding;
	}


	public Integer getSaFee() {
		return saFee;
	}


	public void setSaFee(Integer saFee) {
		this.saFee = saFee;
	}


	public double getRvStar() {
		return rvStar;
	}


	public void setRvStar(double rvStar) {
		this.rvStar = rvStar;
	}


	public int getHeartCount() {
		return heartCount;
	}


	public void setHeartCount(int heartCount) {
		this.heartCount = heartCount;
	}


	
}
