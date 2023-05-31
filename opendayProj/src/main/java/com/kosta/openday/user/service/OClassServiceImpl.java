package com.kosta.openday.user.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.user.dao.OClassDAO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.teacher.dto.ScheduleDTO;

import com.kosta.openday.user.dto.RequestDTO;


@Service
public class OClassServiceImpl implements OClassService {

	@Autowired
	private OClassDAO oClassDAO;
	
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
	public List<RequestDTO> getRequestList() throws Exception {
		// TODO Auto-generated method stub
		return oClassDAO.selectRequestList();
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
	
	
}