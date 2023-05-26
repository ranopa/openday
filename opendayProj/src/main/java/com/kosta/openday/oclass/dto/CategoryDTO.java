package com.kosta.openday.oclass.dto;

public class CategoryDTO {
	private String codNum;
	private String codClassfication;
	private String codName;
	
	public CategoryDTO() {}

	public CategoryDTO(String codNum, String codClassfication, String codName) {
		this.codNum = codNum;
		this.codClassfication = codClassfication;
		this.codName = codName;
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

	public void setCodNum(String codNum) {
		this.codNum = codNum;
	}

	public void setCodClassfication(String codClassfication) {
		this.codClassfication = codClassfication;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	};
	

}
