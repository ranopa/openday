package com.kosta.openday.user.dto;

import com.kosta.openday.teacher.dto.AnswerDTO;

public class ClsInquiryAndAnswerDTO {
	
	private ClsInquiryDTO clsInquiry;
	private AnswerDTO answer;
	public ClsInquiryDTO getClsInquiry() {
		return clsInquiry;
	}
	public void setClsInquiry(ClsInquiryDTO clsInquiry) {
		this.clsInquiry = clsInquiry;
	}
	public AnswerDTO getAnswer() {
		return answer;
	}
	public void setAnswer(AnswerDTO answer) {
		this.answer = answer;
	}
	
	

}

