package com.kosta.openday.adm.dto;

import java.time.LocalDateTime;

public class NotificationDTO {
	private Integer ntfId; // pk 
	private Integer ntfSourceId; // 알림 발생한 객체 id
	private Integer ntfSourceType; // 알림 발생한 객체 타입 
	private String ntfMessage; // 메시지 본문 
	private Boolean ntfIsRead; // 읽음 여부 
	private Boolean ntfIsDeleted; // 삭제 여부 
	private LocalDateTime ntfCreatedAt; // 알림 생성 일자 
	private String ntfUrl;
	private String ntfSenderId; // 발송인 아이디 
	private String ntfReceiverId; // 수신인 아이디 

	public NotificationDTO() {}

	public NotificationDTO(Integer ntfId, Integer ntfSourceId, Integer ntfSourceType, 
			String ntfMessage, Boolean ntfIsRead, Boolean ntfIsDeleted, LocalDateTime ntfCreatedAt,
			String ntfUrl, String ntfSenderId, String ntfReceiverId) {
		this.ntfId = ntfId;
		this.ntfSourceId = ntfSourceId;
		this.ntfSourceType = ntfSourceType;
		this.ntfMessage = ntfMessage;
		this.ntfIsRead = ntfIsRead;
		this.ntfIsDeleted = ntfIsDeleted;
		this.ntfCreatedAt = ntfCreatedAt;
		this.ntfUrl = ntfUrl;
		this.ntfSenderId = ntfSenderId;
		this.ntfReceiverId = ntfReceiverId;
	}

	public Integer getNtfId() {
		return ntfId;
	}

	public void setNtfId(Integer ntfId) {
		this.ntfId = ntfId;
	}

	public Integer getNtfSourceId() {
		return ntfSourceId;
	}

	public void setNtfSourceId(Integer ntfSourceId) {
		this.ntfSourceId = ntfSourceId;
	}

	public Integer getNtfSourceType() {
		return ntfSourceType;
	}

	public void setNtfSourceType(Integer ntfSourceType) {
		this.ntfSourceType = ntfSourceType;
	}

	public String getNtfMessage() {
		return ntfMessage;
	}

	public void setNtfMessage(String ntfMessage) {
		this.ntfMessage = ntfMessage;
	}

	public Boolean getNtfIsRead() {
		return ntfIsRead;
	}

	public void setNtfIsRead(Boolean ntfIsRead) {
		this.ntfIsRead = ntfIsRead;
	}

	public Boolean getNtfIsDeleted() {
		return ntfIsDeleted;
	}

	public void setNtfIsDeleted(Boolean ntfIsDeleted) {
		this.ntfIsDeleted = ntfIsDeleted;
	}

	public LocalDateTime getNtfCreatedAt() {
		return ntfCreatedAt;
	}

	public void setNtfCreatedAt(LocalDateTime ntfCreatedAt) {
		this.ntfCreatedAt = ntfCreatedAt;
	}

	public String getNtfUrl() {
		return ntfUrl;
	}

	public void setNtfUrl(String ntfUrl) {
		this.ntfUrl = ntfUrl;
	}

	public String getNtfSenderId() {
		return ntfSenderId;
	}

	public void setNtfSenderId(String ntfSenderId) {
		this.ntfSenderId = ntfSenderId;
	}

	public String getNtfReceiverId() {
		return ntfReceiverId;
	}

	public void setNtfReceiverId(String ntfReceiverId) {
		this.ntfReceiverId = ntfReceiverId;
	}
	
}
