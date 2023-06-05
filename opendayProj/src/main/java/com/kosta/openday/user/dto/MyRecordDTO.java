package com.kosta.openday.user.dto;

import java.sql.Date;

public class MyRecordDTO {
	//수강신청T
	private Integer apNum; //수강신청번호
	private String apPstatus;  //결제상태 (정상,결제취소)
	private String apAstatus; //수강상태 (수강예정,취소,수강완료)
	private Integer apFinalAmount; //최종결제금액
	private Integer scdNum; //클래스 일정번호 
	 
	//oclass T
	private String clsName; //클래스이름
	private Integer filNum; //파일번호
	//schedule T
	private Date scdDate; //수강일 
	private String strDate; //수강일 string형태로 변환해서 출력
	
	
	public MyRecordDTO() {}


	public MyRecordDTO(Integer apNum, String apPstatus, String apAstatus, Integer apFinalAmount, Integer scdNum,
			String clsName, Integer filNum, Date scdDate, String strDate) {
		super();
		this.apNum = apNum;
		this.apPstatus = apPstatus;
		this.apAstatus = apAstatus;
		this.apFinalAmount = apFinalAmount;
		this.scdNum = scdNum;
		this.clsName = clsName;
		this.filNum = filNum;
		this.scdDate = scdDate;
		this.strDate = strDate;
	}


	public Integer getApNum() {
		return apNum;
	}


	public void setApNum(Integer apNum) {
		this.apNum = apNum;
	}


	public String getApPstatus() {
		return apPstatus;
	}


	public void setApPstatus(String apPstatus) {
		this.apPstatus = apPstatus;
	}


	public String getApAstatus() {
		return apAstatus;
	}


	public void setApAstatus(String apAstatus) {
		this.apAstatus = apAstatus;
	}


	public Integer getApFinalAmount() {
		return apFinalAmount;
	}


	public void setApFinalAmount(Integer apFinalAmount) {
		this.apFinalAmount = apFinalAmount;
	}


	public Integer getScdNum() {
		return scdNum;
	}


	public void setScdNum(Integer scdNum) {
		this.scdNum = scdNum;
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


	public Date getScdDate() {
		return scdDate;
	}


	public void setScdDate(Date scdDate) {
		this.scdDate = scdDate;
	}


	public String getStrDate() {
		return strDate;
	}


	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}


 
	
}
