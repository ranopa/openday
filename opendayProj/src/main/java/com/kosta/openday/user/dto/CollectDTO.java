package com.kosta.openday.user.dto;

public class CollectDTO {
	/*
	 * private ScheduleDTO scheduleDTO; private OClassDTO oclassDTO; private
	 * ReviewDTO reviewDTO; private UserDTO userDTO;
	 */
	private Integer clsId; //클래스 번호 
	private String scdLoc; //장소
	private Integer scdDiscount; //할인율
	private String clsName; // 클래스명
	private String codName; // 코드(카테고리)이름
	private Integer clsPrice; // 클래스 수강료
	private Integer clsStar; // 별점
	private Integer clsHeart; // 하트수
	private Integer filNum; // 클래스이미지 
	private Integer reviewCount; //후기수
	private String clsLoc; //지역
	private Integer clsDiscount;//할인율
	private Integer finalPrice;//최종가격
	
	public CollectDTO() {}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getScdLoc() {
		return scdLoc;
	}

	public void setScdLoc(String scdLoc) {
		this.scdLoc = scdLoc;
	}

	public Integer getScdDiscount() {
		return scdDiscount;
	}

	public void setScdDiscount(Integer scdDiscount) {
		this.scdDiscount = scdDiscount;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getCodName() {
		return codName;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	}

	public Integer getClsPrice() {
		return clsPrice;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
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

	public Integer getFilNum() {
		return filNum;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
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

	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	@Override
	public String toString() {
		return "CollectDTO [clsId=" + clsId + ", scdLoc=" + scdLoc + ", scdDiscount=" + scdDiscount + ", clsName="
				+ clsName + ", codName=" + codName + ", clsPrice=" + clsPrice + ", clsStar=" + clsStar + ", clsHeart="
				+ clsHeart + ", filNum=" + filNum + ", reviewCount=" + reviewCount + ", clsLoc=" + clsLoc
				+ ", clsDiscount=" + clsDiscount + ", finalPrice=" + finalPrice + "]";
	}
	
	

	
	

}
