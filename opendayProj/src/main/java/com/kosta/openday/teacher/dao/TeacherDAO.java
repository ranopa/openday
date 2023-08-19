package com.kosta.openday.teacher.dao;

import java.util.HashMap;
import java.util.List;

import com.kosta.openday.adm.dto.AnnouncementDTO;
import com.kosta.openday.adm.dto.FileDTO;
import com.kosta.openday.teacher.dto.ClassScdUserDTO;
import com.kosta.openday.teacher.dto.ClassScheduleDTO;
import com.kosta.openday.teacher.dto.SettlementAmountDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.teacher.dto.TeacherScheduleDTO;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
public interface TeacherDAO {
	List<AnnouncementDTO> tcAnnouncementList() throws Exception;
	List<OClassDTO> tcClassList(HashMap<String, Object> map) throws Exception;
	int tcClassListCount(HashMap<String, Object> map) throws Exception;
	List<ClassScheduleDTO> tcClassScheduleList(HashMap<String, Object> map) throws Exception;
	List<ClassScdUserDTO> tcClassUserList(Integer scdNum) throws Exception;
	int tcClassScheduleListCount(HashMap<String, Object> map) throws Exception;
	List<ClsInquiryDTO> tcClassInquiryList(Integer clsId) throws Exception;
	List<TeacherScheduleDTO> tcScheduleList(HashMap<String, Object> map) throws Exception;
	List<OClassDTO> tcClassSalesList(HashMap<String, Object> map) throws Exception;
	int tcClassSalesListCount(HashMap<String, Object> map) throws Exception;
	List<SettlementAmountDTO> tcSalesList(HashMap<String, Object> map) throws Exception;
	void tcProfileAdd(FileDTO dto) throws Exception;
	void tcProfileUpdate(FileDTO dto) throws Exception;
	FileDTO tcProfileInfo(int filNum) throws Exception;
	void tcProfileUserUpdate(TeacherChannelDTO dto) throws Exception;
	void tcProfileUserImgUpdate(TeacherChannelDTO dto) throws Exception;
	TeacherChannelDTO tcChannelInfo(String userId) throws Exception;
	TeacherChannelDTO tcProfileSelect(HashMap<String, Object> map) throws Exception;
	int tcSalesTotal(HashMap<String, Object> map) throws Exception;
	int tcSalesMonthTotal(HashMap<String, Object> map) throws Exception;
	int tcClassListStatus1Count(HashMap<String, Object> map) throws Exception;
	int tcClassListStatus2Count(HashMap<String, Object> map) throws Exception;
	int tcClassListReviewCount(HashMap<String, Object> map) throws Exception;
	double tcClassListAvgStarCount(HashMap<String, Object> map) throws Exception;
	AnnouncementDTO tcAnnouncementInfo(int ancId) throws Exception;
	void SalesAdd(HashMap<String, Object> map) throws Exception;
}	

