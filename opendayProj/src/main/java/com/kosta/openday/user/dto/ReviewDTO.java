package com.kosta.openday.user.dto;

import java.sql.Date;

//후기T
public class ReviewDTO {
	private Integer rvNum; //후기번호
	private String rvTitle; //제목
	private String rvContent; //내용
	private Date rvDate; //작성일
	private Integer rvStar; //별점
	private String userId; //아이디
	private Integer scdNum; //클래스일정번호
	
	public ReviewDTO() {}
	public ReviewDTO(Integer rvNum, String rvTitle, String rvContent, Date rvDate, Integer rvStar, String userId,
			Integer scdNum) {
		super();
		this.rvNum = rvNum;
		this.rvTitle = rvTitle;
		this.rvContent = rvContent;
		this.rvDate = rvDate;
		this.rvStar = rvStar;
		this.userId = userId;
		this.scdNum = scdNum;
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
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getScdNum() {
		return scdNum;
	}
	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
	}
	
	
	
	
	
}
