package com.kosta.openday.user.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dto.OClassAndScheduleDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.teacher.dto.TeacherChannelDTO;
import com.kosta.openday.user.dao.OClassDAO;
import com.kosta.openday.user.dto.ApplyClassResponseDTO;
import com.kosta.openday.user.dto.ClsInquiryAndAnswerDTO;
import com.kosta.openday.user.dto.ClsInquiryDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.PageInfo;
import com.kosta.openday.user.dto.RequestDTO;
import com.kosta.openday.user.dto.ReviewDTO;


@Service
public class OClassServiceImpl implements OClassService {

	@Autowired
	private OClassDAO oClassDAO;
	
	@Autowired
	private PaymentService paymentService;
	
	@Override
	public OClassDTO findOne(Integer clsId) throws Exception {
		return oClassDAO.selectOClassById(clsId);
	}

	@Override
	public List<OClassDTO> findAll() throws Exception {
		return oClassDAO.selectOClassList();
	}

	@Override
	public void save(OClassDTO dto) throws Exception {
		oClassDAO.insertOClass(dto);
	}
	
	@Override
	public List<ScheduleDTO> findScheduleByClassId(Integer clsId) throws Exception {
		return oClassDAO.selectScheduleByOClass(clsId);
	}

	@Override
	public List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception {
		Map<String,Object> param = new HashMap<>();
		param.put("scdLoc", loc);
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("clsCode", clsCode);
		// TODO Auto-generated method stub
		return oClassDAO.selectOClassListByParam(param);
	}

	
	@Override
	public void requestClass(RequestDTO request) throws Exception {
		oClassDAO.insertRequest(request);
		
	}

	@Override
	public List<RequestDTO> getRequestList(PageInfo pageInfo) throws Exception {
		// TODO Auto-generated method stub
		int totalCount=oClassDAO.selectAllRequestCnt();
		int maxPage=totalCount/5;;
		if(totalCount%10!=0) maxPage+=1;
		
		int startPage=pageInfo.getCurPage()/5;
		if(pageInfo.getCurPage()%10==0) startPage-=1;
		startPage=startPage*5+1;
		
		int endPage=startPage+5-1;
		if(endPage>maxPage) endPage=maxPage;
		
		pageInfo.setAllPage(maxPage);
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);

		int startrow =(pageInfo.getCurPage()-1)*5+1;
		return oClassDAO.selectRequestList(startrow-1);
	}

	 
	@Override
	public RequestDTO getRequest(Integer reqId) throws Exception {
		// TODO Auto-generated method stub
		plusViewCount(reqId);
		return oClassDAO.selectRequest(reqId);
	}

	@Override
	public void plusViewCount(Integer reqId) throws Exception {
		oClassDAO.updateReqViews(reqId);
	}

	@Override
	public void modifyRequest(RequestDTO request) throws Exception {
		oClassDAO.updateRequest(request);
		
	}

	
	@Override
	public void removeRequest(Integer reqId) throws Exception {
		oClassDAO.deleteRequest(reqId);
		
	}

	@Override
	public Integer getPartpaCntByReqId(Integer reqId) throws Exception {
		return oClassDAO.selectPartpaCntByReqId(reqId);
	}

	@Override
	public Integer getPartPaYN(String userId, Integer reqId) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("userId", userId);
		param.put("reqId", reqId);
		return oClassDAO.selectPartpaYN(param);
	}

	@Override
	public Boolean coupleParticipation(String userId, Integer reqId) throws Exception {
		
		Integer ys = getPartPaYN(userId, reqId); 
		Map<String, Object> param = new HashMap<>();
		param.put("userId", userId);
		param.put("reqId", reqId);
		if(ys==1) { //삭제
			oClassDAO.deleteParticipation(param);
			return false;
		} else { //삽입
			oClassDAO.insertParticipation(param);
			return true;
		}
	}

	@Override
	public ScheduleDTO findScheduleById(Integer scdNum) throws Exception {
		// TODO Auto-generated method stub
		return oClassDAO.selectSchedule(scdNum);
	}

	@Override
	public ApplyClassResponseDTO getApplyClassResponse(Integer clsId) throws Exception {
		ApplyClassResponseDTO dto = oClassDAO.selectOClassAndScheduleForApplyClass(clsId);
		Integer discountedPrice = paymentService.applyDiscount(dto.getClsPrice(), dto.getClsDiscount());
		
		dto.setDiscountedPrice(discountedPrice);
		
		return dto;
	}
	
	@Override
	public Map<String, Object> getOclassDetail(Integer clsId, String userId) throws Exception {
		//클래스번호,클래스명,파일명,가격,소개,커리,장소
		Map<String, Object> clsInfo = oClassDAO.selectOclassDetail(clsId);
		
		//장소
		List<ScheduleDTO> scheduleList  = oClassDAO.selectScheduleByOClass(clsId);
		//후기
		List<ReviewDTO> reviewList = oClassDAO.selectReviewByClsId(clsId);
		//문의&답변
		List<ClsInquiryAndAnswerDTO> inquiryAndAnswerList = oClassDAO.selectInquiryAndAnswerByClsId(clsId);
		//강사채널
		TeacherChannelDTO teacherChannel = getTeacherChannel(userId);
		//찜수
		Integer heartCnt = oClassDAO.selectHeartCntByClsId(clsId);
		//찜여부
		Map<String,Object> param = new HashMap<>();
		param.put("clsId", clsId);
		param.put("userId", userId);
		Integer heart = oClassDAO.selectHeartByClsIdAndUser(param);
		System.out.println(heart);
		Map<String, Object> result = new HashMap<>();
		result.put("clsInfo", clsInfo);
		result.put("scheduleList", scheduleList);
		result.put("reviewList", reviewList);
		result.put("inquiryList", inquiryAndAnswerList);
		if(teacherChannel!=null) {
			result.put("teacherChannel", teacherChannel.getTchcNum());
		}
		result.put("heartCnt", heartCnt);
		result.put("heart", heart);
		return result;
	}

	@Override
	public Integer toggleHeartSchedule(Integer clsId, String userId) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("clsId", clsId);
		param.put("userId", userId);
		
		Integer heartYN = oClassDAO.selectHeartByClsIdAndUser(param);
		if(heartYN==1) {
			oClassDAO.deleteHeartByClsIdAndUser(param);
		} else {
			oClassDAO.insertHeartByClsIdAndUser(param);
		}
		
		return oClassDAO.selectHeartCntByClsId(clsId);
	}

	@Override
	public List<OClassAndScheduleDTO> findClassAndSchedules() throws Exception {
		return oClassDAO.selectOClassAndSchedules();
	}

	@Override
	public void clsInquiry(String ciContent, String ciSecret, Integer clsId, String userId) throws Exception {
		Map<String, Object> param = new HashMap<>();
		param.put("ciContent", ciContent);
		if(ciSecret.equals("true")) {
			param.put("ciSecret", 1);
		} else {
			param.put("ciSecret", 0);
		}
		param.put("clsId", clsId);
		param.put("userId", userId);
		oClassDAO.insertClsInquiry(param);
	}

	@Override
	public void modifyClsInquiry(String ciContent, String ciSecret, Integer ciNum) throws Exception {
		System.out.println(ciContent);
		Map<String, Object> param = new HashMap<>();
		param.put("ciContent", ciContent);
		if(ciSecret.equals("true")) {
			param.put("ciSecret", 1);
		} else {
			param.put("ciSecret", 0);
		}
		param.put("ciNum", ciNum);	
		System.out.println(param);
		oClassDAO.updateClsInquiry(param);
	}

	@Override
	public void removeReview(Integer rvNum) throws Exception {
		oClassDAO.deleteReview(rvNum);
		
	}

	@Override
	public TeacherChannelDTO getTeacherChannel(String userId) throws Exception {
		// TODO Auto-generated method stub
		return oClassDAO.selectteacherChannel(userId);
	}
}
