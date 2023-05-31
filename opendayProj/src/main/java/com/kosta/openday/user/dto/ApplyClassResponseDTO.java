package com.kosta.openday.user.dto;

import java.util.ArrayList;
import java.util.List;

public class ApplyClassResponseDTO {
	private Integer clsId;
	private String clsName;
	private String codName;
	private Integer filNum;
	private Integer clsPrice;
	
	List<ApplyScheduleDTO> schedules = new ArrayList<>();

	public ApplyClassResponseDTO() {}
	
	public ApplyClassResponseDTO(Integer clsId, String clsName, String codName, Integer filNum, Integer clsPrice,
			List<ApplyScheduleDTO> schedules) {
		this.clsId = clsId;
		this.clsName = clsName;
		this.codName = codName;
		this.filNum = filNum;
		this.clsPrice = clsPrice;
		this.schedules = schedules;
	}

	public Integer getClsId() {
		return clsId;
	}

	public void setClsId(Integer clsId) {
		this.clsId = clsId;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getCodName() {
		return codName;
	}

	public void setCodName(String codName) {
		this.codName = codName;
	}

	public Integer getFilNum() {
		return filNum;
	}

	public void setFilNum(Integer filNum) {
		this.filNum = filNum;
	}

	public Integer getClsPrice() {
		return clsPrice;
	}

	public void setClsPrice(Integer clsPrice) {
		this.clsPrice = clsPrice;
	}

	public List<ApplyScheduleDTO> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<ApplyScheduleDTO> schedules) {
		this.schedules = schedules;
	}
	
	
}