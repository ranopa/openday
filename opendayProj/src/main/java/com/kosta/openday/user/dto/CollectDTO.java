package com.kosta.openday.user.dto;

import java.sql.Date;

import com.kosta.openday.teacher.dto.ScheduleDTO;


public class CollectDTO {
	/*
	 * private ScheduleDTO scheduleDTO; private OClassDTO oclassDTO; private
	 * ReviewDTO reviewDTO; private UserDTO userDTO;
	 */
	private String scdLoc; //장소
	private Integer scdDiscount; //할인율
	private String clsName; // 클래스명
	private String clsCode; // 코드(카테고리)
	private Integer clsPrice; // 클래스 수강료
	private Integer clsStar; // 별점
	private Integer clsHeart; // 하트수
	private Integer filNum; // 클래스이미지 
	private Integer reviewCount; //후기수
	private Integer finalPrice;
	
	public CollectDTO() {}
	
	

	public CollectDTO(String scdLoc, Integer scdDiscount, String clsName, String clsCode, Integer clsPrice,
			Integer clsStar, Integer clsHeart, Integer filNum, Integer reviewCount, Integer finalPrice) {
		super();
		this.scdLoc = scdLoc;
		this.scdDiscount = scdDiscount;
		this.clsName = clsName;
		this.clsCode = clsCode;
		this.clsPrice = clsPrice;
		this.clsStar = clsStar;
		this.clsHeart = clsHeart;
		this.filNum = filNum;
		this.reviewCount = reviewCount;
		this.finalPrice = finalPrice;
	}



	public String getClsCode() {
		return clsCode;
	}
	public void setClsCode(String clsCode) {
		this.clsCode = clsCode;
	}
	public String getScdLoc() {
		return scdLoc;
	}
	public void setScdLoc(String scdLoc) {
		this.scdLoc = scdLoc;
	}
	public Integer getClsPrice() {
		return clsPrice;
	}
	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}
	public String getClsName() {
		return clsName;
	}
	public void setClsName(String clsName) {
		this.clsName = clsName;
	}
	public Integer getFilNum() {
		return filNum;
	}
	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
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
	public Integer getScdDiscount() {
		return scdDiscount;
	}
	public void setScdDiscount(Integer scdDiscount) {
		this.scdDiscount = scdDiscount;
	}
	public Integer getReviewCount() {
		return reviewCount;
	}
	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}
	public Integer getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}


	@Override
	public String toString() {
		return "CollectDTO [clsCode=" + clsCode + ", scdLoc=" + scdLoc + ", clsPrice=" + clsPrice + ", clsName="
				+ clsName + ", filNum=" + filNum + ", clsStar=" + clsStar + ", clsHeart=" + clsHeart + ", scdDiscount="
				+ scdDiscount + ", reviewCount=" + reviewCount + ", finalPrice=" + finalPrice + "]";
	}
	
	
	
	

}
