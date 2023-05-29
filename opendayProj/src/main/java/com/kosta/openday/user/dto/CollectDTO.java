package com.kosta.openday.user.dto;

import com.kosta.openday.teacher.dto.ScheduleDTO;


public class CollectDTO {
	private ScheduleDTO scheduleDTO;
	private OClassDTO oclassDTO;
	private ReviewDTO reviewDTO;
	private UserDTO userDTO;
	private Integer reviewCount;
	private Integer finalPrice;
	public ScheduleDTO getScheduleDTO() {
		return scheduleDTO;
	}
	public void setScheduleDTO(ScheduleDTO scheduleDTO) {
		this.scheduleDTO = scheduleDTO;
	}
	public OClassDTO getOclassDTO() {
		return oclassDTO;
	}
	public void setOclassDTO(OClassDTO oclassDTO) {
		this.oclassDTO = oclassDTO;
	}
	public ReviewDTO getReviewDTO() {
		return reviewDTO;
	}
	public void setReviewDTO(ReviewDTO reviewDTO) {
		this.reviewDTO = reviewDTO;
	}
	
	
	
	

}
