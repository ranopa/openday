package com.kosta.openday.user.dto;

import java.sql.Date;
import java.sql.Time;

public class CollectOptionDTO {
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
	private Integer  saFee;
	
	private Integer rvNum; //후기번호
	private String rvTitle; //제목
	private String rvContent; //내용
	private Date rvDate; //작성일
	private Integer rvStar; //별점

	private Integer scdNum; //클래스일정번호
	

	private Date scdDate; //강의일
	private Time scdTime; //소요시간

	private String scdPlace; //장소
	private String scdPlaceDetail; //세부장소
	private Integer scdMinPersonnel; //모집인원
	private Integer scdMaxPersonnel; //모집인원
	private Date scdUploadDate; //등록일 
	private String scdStatus; //강의상태 (예정/폐강/완료)
	public CollectOptionDTO(Integer clsId, String clsName, String clsCode, String clsDescription, Integer clsPrice,
			String clsCurri, String clsCareer, String clsStatus, String clsLoc, Integer clsDiscount, Date clsCreatedAt,
			String clsOpenType, Integer filNum, String userId, Integer reqId, Integer clsInquiry, Integer totPrice,
			Integer amountPaid, Integer amountOutstanding, Integer saFee, Integer rvNum, String rvTitle,
			String rvContent, Date rvDate, Integer rvStar, Integer scdNum, Date scdDate, Time scdTime, String scdPlace,
			String scdPlaceDetail, Integer scdMinPersonnel, Integer scdMaxPersonnel, Date scdUploadDate,
			String scdStatus) {
		super();
		this.clsId = clsId;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.clsDescription = clsDescription;
		this.clsPrice = clsPrice;
		this.clsCurri = clsCurri;
		this.clsCareer = clsCareer;
		this.clsStatus = clsStatus;
		this.clsLoc = clsLoc;
		this.clsDiscount = clsDiscount;
		this.clsCreatedAt = clsCreatedAt;
		this.clsOpenType = clsOpenType;
		this.filNum = filNum;
		this.userId = userId;
		this.reqId = reqId;
		this.clsInquiry = clsInquiry;
		this.totPrice = totPrice;
		this.amountPaid = amountPaid;
		this.amountOutstanding = amountOutstanding;
		this.saFee = saFee;
		this.rvNum = rvNum;
		this.rvTitle = rvTitle;
		this.rvContent = rvContent;
		this.rvDate = rvDate;
		this.rvStar = rvStar;
		this.scdNum = scdNum;
		this.scdDate = scdDate;
		this.scdTime = scdTime;
		this.scdPlace = scdPlace;
		this.scdPlaceDetail = scdPlaceDetail;
		this.scdMinPersonnel = scdMinPersonnel;
		this.scdMaxPersonnel = scdMaxPersonnel;
		this.scdUploadDate = scdUploadDate;
		this.scdStatus = scdStatus;
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
	public Integer getRvNum() {
		return rvNum;
	}
	public void setRvNum(Integer rvNum) {
		this.rvNum = rvNum;
	}
	public String getRvTitle() {
		return rvTitle;
	}
	public void setRvTitle(String rvTitle) {
		this.rvTitle = rvTitle;
	}
	public String getRvContent() {
		return rvContent;
	}
	public void setRvContent(String rvContent) {
		this.rvContent = rvContent;
	}
	public Date getRvDate() {
		return rvDate;
	}
	public void setRvDate(Date rvDate) {
		this.rvDate = rvDate;
	}
	public Integer getRvStar() {
		return rvStar;
	}
	public void setRvStar(Integer rvStar) {
		this.rvStar = rvStar;
	}
	public Integer getScdNum() {
		return scdNum;
	}
	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}
	public Date getScdDate() {
		return scdDate;
	}
	public void setScdDate(Date scdDate) {
		this.scdDate = scdDate;
	}
	public Time getScdTime() {
		return scdTime;
	}
	public void setScdTime(Time scdTime) {
		this.scdTime = scdTime;
	}
	public String getScdPlace() {
		return scdPlace;
	}
	public void setScdPlace(String scdPlace) {
		this.scdPlace = scdPlace;
	}
	public String getScdPlaceDetail() {
		return scdPlaceDetail;
	}
	public void setScdPlaceDetail(String scdPlaceDetail) {
		this.scdPlaceDetail = scdPlaceDetail;
	}
	public Integer getScdMinPersonnel() {
		return scdMinPersonnel;
	}
	public void setScdMinPersonnel(Integer scdMinPersonnel) {
		this.scdMinPersonnel = scdMinPersonnel;
	}
	public Integer getScdMaxPersonnel() {
		return scdMaxPersonnel;
	}
	public void setScdMaxPersonnel(Integer scdMaxPersonnel) {
		this.scdMaxPersonnel = scdMaxPersonnel;
	}
	public Date getScdUploadDate() {
		return scdUploadDate;
	}
	public void setScdUploadDate(Date scdUploadDate) {
		this.scdUploadDate = scdUploadDate;
	}
	public String getScdStatus() {
		return scdStatus;
	}
	public void setScdStatus(String scdStatus) {
		this.scdStatus = scdStatus;
	}
	@Override
	public String toString() {
		return "CollectOptionDTO [clsId=" + clsId + ", clsName=" + clsName + ", clsCode=" + clsCode
				+ ", clsDescription=" + clsDescription + ", clsPrice=" + clsPrice + ", clsCurri=" + clsCurri
				+ ", clsCareer=" + clsCareer + ", clsStatus=" + clsStatus + ", clsLoc=" + clsLoc + ", clsDiscount="
				+ clsDiscount + ", clsCreatedAt=" + clsCreatedAt + ", clsOpenType=" + clsOpenType + ", filNum=" + filNum
				+ ", userId=" + userId + ", reqId=" + reqId + ", clsInquiry=" + clsInquiry + ", totPrice=" + totPrice
				+ ", amountPaid=" + amountPaid + ", amountOutstanding=" + amountOutstanding + ", saFee=" + saFee
				+ ", rvNum=" + rvNum + ", rvTitle=" + rvTitle + ", rvContent=" + rvContent + ", rvDate=" + rvDate
				+ ", rvStar=" + rvStar + ", scdNum=" + scdNum + ", scdDate=" + scdDate + ", scdTime=" + scdTime
				+ ", scdPlace=" + scdPlace + ", scdPlaceDetail=" + scdPlaceDetail + ", scdMinPersonnel="
				+ scdMinPersonnel + ", scdMaxPersonnel=" + scdMaxPersonnel + ", scdUploadDate=" + scdUploadDate
				+ ", scdStatus=" + scdStatus + "]";
	}

}
