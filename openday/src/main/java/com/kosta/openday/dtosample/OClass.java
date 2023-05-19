package com.kosta.openday.dtosample;

public class OClass {
	private Integer cls_id;// 클래스번호 
	private String cls_name; // 클래스명
	private String cls_code; // 코드(카테고리)
	private String cls_description; // 소개글
	private String cls_curri;// 커리큘럼
	private Integer cls_star; // 별점
	private Integer cls_heart; // 하트수
	private String cls_status; // 상태
	private Integer cls_created_at; // 등록일
	private Integer cls_open_type; // 개설유형
	private Integer user_id; // 강사번호
	private Integer fil_id; // 파일번호
	private Integer req_id; // 글번호

	public Integer getCls_id() {
		return cls_id;
	}

	public void setCls_id(Integer cls_id) {
		this.cls_id = cls_id;
	}

	public String getCls_name() {
		return cls_name;
	}

	public void setCls_name(String cls_name) {
		this.cls_name = cls_name;
	}

	public String getCls_code() {
		return cls_code;
	}

	public void setCls_code(String cls_code) {
		this.cls_code = cls_code;
	}

	public String getCls_description() {
		return cls_description;
	}

	public void setCls_description(String cls_description) {
		this.cls_description = cls_description;
	}

	public String getCls_curri() {
		return cls_curri;
	}

	public void setCls_curri(String cls_curri) {
		this.cls_curri = cls_curri;
	}

	public Integer getCls_star() {
		return cls_star;
	}

	public void setCls_star(Integer cls_star) {
		this.cls_star = cls_star;
	}

	public Integer getCls_heart() {
		return cls_heart;
	}

	public void setCls_heart(Integer cls_heart) {
		this.cls_heart = cls_heart;
	}

	public String getCls_status() {
		return cls_status;
	}

	public void setCls_status(String cls_status) {
		this.cls_status = cls_status;
	}

	public Integer getCls_created_at() {
		return cls_created_at;
	}

	public void setCls_created_at(Integer cls_created_at) {
		this.cls_created_at = cls_created_at;
	}

	public Integer getCls_open_type() {
		return cls_open_type;
	}

	public void setCls_open_type(Integer cls_open_type) {
		this.cls_open_type = cls_open_type;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFil_id() {
		return fil_id;
	}

	public void setFil_id(Integer fil_id) {
		this.fil_id = fil_id;
	}

	public Integer getReq_id() {
		return req_id;
	}

	public void setReq_id(Integer req_id) {
		this.req_id = req_id;
	}

	public OClass(Integer cls_id, String cls_name, String cls_code, String cls_description, String cls_curri,
			Integer cls_star, Integer cls_heart, String cls_status, Integer cls_created_at, Integer cls_open_type,
			Integer user_id, Integer fil_id, Integer req_id) {
		super();
		this.cls_id = cls_id;
		this.cls_name = cls_name;
		this.cls_code = cls_code;
		this.cls_description = cls_description;
		this.cls_curri = cls_curri;
		this.cls_star = cls_star;
		this.cls_heart = cls_heart;
		this.cls_status = cls_status;
		this.cls_created_at = cls_created_at;
		this.cls_open_type = cls_open_type;
		this.user_id = user_id;
		this.fil_id = fil_id;
		this.req_id = req_id;
	}

}
