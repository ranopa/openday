package com.kosta.openday.user.dto;

public class PageInfo {
	private Integer allPage;
	private Integer curPage;
	private Integer startPage;
	private Integer endPage;
	
	public PageInfo() {}
	public PageInfo(Integer allPage,Integer curPage, Integer startPage, Integer endPage) {
		this.allPage=allPage;
		this.curPage=curPage;
		this.startPage=startPage;
		this.endPage=endPage;
	}
	
	public Integer getAllPage() {
		return allPage;
	}
	public void setAllPage(Integer allPage) {
		this.allPage = allPage;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getStartPage() {
		return startPage;
	}
	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}
	public Integer getEndPage() {
		return endPage;
	}
	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}	
}
