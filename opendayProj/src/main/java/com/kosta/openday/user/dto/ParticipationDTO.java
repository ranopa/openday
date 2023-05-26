package com.kosta.openday.user.dto;

//개설요청 - 참여
public class ParticipationDTO {
	private String userId; //참여자
	private String reqId; //글번호
	
	public ParticipationDTO() {}

	public ParticipationDTO(String userId, String reqId) {
		super();
		this.userId = userId;
		this.reqId = reqId;
	}

	public String getUserId() {
		return userId;
	}

	public String getReqId() {
		return reqId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setReqId(String reqId) {
		this.reqId = reqId;
	};
	
	
	
}
