package com.kosta.openday.user.dto;

public class CollectDTO {
	 
	private Integer clsId; //클래스 번호 
	private String clsLoc; //장소
	private Integer clsPrice; // 클래스 수강료
	private Integer clsDiscount; //할인율
	private String clsName; // 클래스명
	private String codName; // 코드(카테고리)이름
	private Integer filNum; // 클래스이미지  
	
	private Double avgStar; // 별점
	private Integer heartCnt; // 하트수 
	private Integer reviewCount; //후기수  
	private Integer finalPrice;//최종가격
	
	public CollectDTO() {}
	

	public CollectDTO(Integer clsId, String clsLoc, Integer clsPrice, Integer clsDiscount, String clsName,
			String codName, Integer filNum, Double avgStar, Integer heartCnt, Integer reviewCount, Integer finalPrice) {
		super();
		this.clsId = clsId;
		this.clsLoc = clsLoc;
		this.clsPrice = clsPrice;
		this.clsDiscount = clsDiscount;
		this.clsName = clsName;
		this.codName = codName;
		this.filNum = filNum;
		this.avgStar = avgStar;
		this.heartCnt = heartCnt;
		this.reviewCount = reviewCount;
		this.finalPrice = finalPrice;
	}


	public Integer getClsId() {
		return clsId;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public Integer getClsPrice() {
		return clsPrice;
	}

	public Integer getClsDiscount() {
		return clsDiscount;
	}

	public String getClsName() {
		return clsName;
	}

	public String getCodName() {
		return codName;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public Double getAvgStar() {
		return avgStar;
	}

	public Integer getHeartCnt() {
		return heartCnt;
	}

	public Integer getReviewCount() {
		return reviewCount;
	}

	public Integer getFinalPrice() {
		return finalPrice;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}

	public void setClsDiscount(Integer clsDiscount) {
		this.clsDiscount = clsDiscount;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public void setAvgStar(Double avgStar) {
		this.avgStar = avgStar;
	}

	public void setHeartCnt(Integer heartCnt) {
		this.heartCnt = heartCnt;
	}

	public void setReviewCount(Integer reviewCount) {
		this.reviewCount = reviewCount;
	}

	public void setFinalPrice(Integer finalPrice) {
		this.finalPrice = finalPrice;
	}

	
	

	

}
