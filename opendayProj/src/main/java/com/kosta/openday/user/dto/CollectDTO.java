package com.kosta.openday.user.dto;

public class CollectDTO {
	 
	private Integer clsId; //클래스 번호 
	private String clsLoc; //장소
	private Integer clsPrice; // 클래스 수강료
	private Integer clsDiscount; //할인율
	private String clsName; // 클래스명
	private String codName; // 코드(카테고리)이름
	private Integer filNum; // 클래스이미지  
	
	private String keyword;
	
	private Double avgStar; // 별점
	private Integer heartCnt; // 하트수 
	private Integer reviewCount; //후기수  
	private Integer finalPrice;//최종가격
	
	private String tchcNickname;
	private Integer tFilNum;
	
	private String codNum;
	
	public CollectDTO() {}

	public CollectDTO(Integer clsId, String clsLoc, Integer clsPrice, Integer clsDiscount, String clsName,
			String codName, Integer filNum, String keyword, Double avgStar, Integer heartCnt, Integer reviewCount,
			Integer finalPrice, String tchcNickname, Integer tFilNum, String codNum) {
		super();
		this.clsId = clsId;
		this.clsLoc = clsLoc;
		this.clsPrice = clsPrice;
		this.clsDiscount = clsDiscount;
		this.clsName = clsName;
		this.codName = codName;
		this.filNum = filNum;
		this.keyword = keyword;
		this.avgStar = avgStar;
		this.heartCnt = heartCnt;
		this.reviewCount = reviewCount;
		this.finalPrice = finalPrice;
		this.tchcNickname = tchcNickname;
		this.tFilNum = tFilNum;
		this.codNum = codNum;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getClsLoc() {
		return clsLoc;
	}

	public void setClsLoc(String clsLoc) {
		this.clsLoc = clsLoc;
	}

	public Integer getClsPrice() {
		return clsPrice;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}

	public Integer getClsDiscount() {
		return clsDiscount;
	}

	public void setClsDiscount(Integer clsDiscount) {
		this.clsDiscount = clsDiscount;
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

	public Integer getFilNum() {
		return filNum;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Double getAvgStar() {
		return avgStar;
	}

	public void setAvgStar(Double avgStar) {
		this.avgStar = avgStar;
	}

	public Integer getHeartCnt() {
		return heartCnt;
	}

	public void setHeartCnt(Integer heartCnt) {
		this.heartCnt = heartCnt;
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

	public String getTchcNickname() {
		return tchcNickname;
	}

	public void setTchcNickname(String tchcNickname) {
		this.tchcNickname = tchcNickname;
	}

	public Integer gettFilNum() {
		return tFilNum;
	}

	public void settFilNum(Integer tFilNum) {
		this.tFilNum = tFilNum;
	}

	public String getCodNum() {
		return codNum;
	}

	public void setCodNum(String codNum) {
		this.codNum = codNum;
	}

	@Override
	public String toString() {
		return "CollectDTO [clsId=" + clsId + ", clsLoc=" + clsLoc + ", clsPrice=" + clsPrice + ", clsDiscount="
				+ clsDiscount + ", clsName=" + clsName + ", codName=" + codName + ", filNum=" + filNum + ", keyword="
				+ keyword + ", avgStar=" + avgStar + ", heartCnt=" + heartCnt + ", reviewCount=" + reviewCount
				+ ", finalPrice=" + finalPrice + ", tchcNickname=" + tchcNickname + ", tFilNum=" + tFilNum + ", codNum="
				+ codNum + "]";
	}


	


	


}
