package com.kosta.openday.adm.dto;

import java.util.function.Function;

public enum NotificationSourceType {	

	// 공통) 문의에 답변 관련 
	OCLASS_INQUIRY_ANSWER(1, "문의에 답변이 달렸습니다.", (clsId) -> String.format("/classinfo/%d",clsId)),
	ADMIN_INQUIRY_ANSWER(2, "문의에 답변이 달렸습니다.", (inquiryId) -> String.format("/inquiryDetail/%d", inquiryId)),
	ADMIN_ANNOUNCE(3, "공지가 등록되었습니다.", (ancId) -> String.format("/admannouncementdetail/%d",ancId)),

	// 수강생 
	REQUIRED_OCLASS_OPEN(4,  "클래스가 개설되었습니다.",  (clsId) -> String.format("/classinfo/%d", clsId)),
	OCLASS_APPLY_DONE(5, "신청이 완료되었습니다.", (none) -> "/reservedrecord"),
	OCLASS_CANCELED(6, "신청이 취소되었습니다.", (none) -> "/reservedrecord"),
	
	// 강사
	SETTLEMENT_DONE(7, "정산이 완료되었습니다.", (none) -> "/tcClsSales"),
	OCLASS_ALLOW(8, "클래스 개설 신청이 승인되었습니다.", (clsId) -> String.format("/classinfo/%d", clsId)),
	OCLASS_REFUSE(9, "클래스 개설 신청이 거절되었습니다.", (none) -> "/tcClass");
	
	private final Integer type;
	private final String message;
	private final Function<Integer, String> function;
	
	NotificationSourceType(Integer type, String message, Function<Integer, String> function) {
		this.type = type;
		this.message = message;
		this.function = function;
	}
	
	public String getTargetUrl(Integer targetId) {
		return this.function.apply(targetId);
	}
	
	public Integer getType() {
		return type;
	}
	public String getName() {
		return message;
	}
	
	public String buildMessage(String targetName) {
		if (targetName.length() > 12) {
			targetName = targetName.substring(0, 10)+ "..";
		}
		return "[" + targetName + "]" + this.message;
	}
	
}
