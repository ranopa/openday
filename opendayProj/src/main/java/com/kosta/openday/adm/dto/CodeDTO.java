package com.kosta.openday.adm.dto;

import java.sql.Date;

public class CodeDTO {
	private String codNum;
	private String codClassfication;
	private String codName;
	private Date codNewdate;
	
	public CodeDTO() {}
	
	public CodeDTO(String codNum, String codClassfication, String codName, Date codNewdate) {
		super();
		this.codNum = codNum;
		this.codClassfication = codClassfication;
		this.codName = codName;
		this.codNewdate = codNewdate;
	}

	public String getCodNum() {
		return codNum;
	}

	public String getCodClassfication() {
		return codClassfication;
	}

	public String getCodName() {
		return codName;
	}

	public Date getCodNewdate() {
		return codNewdate;
	}

	public void setCodNum(String codNum) {
		this.codNum = codNum;
	}

	public void setCodClassfication(String codClassfication) {
		this.codClassfication = codClassfication;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	}

	public void setCodNewdate(Date codNewdate) {
		this.codNewdate = codNewdate;
	}
	
	
	
}
