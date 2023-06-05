package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.user.dto.OClassDTO;

public interface AdmDAO {

	List<OClassDTO> selectOClassByStatus(String status) throws Exception;

	void updateOClassStatus(Map<String, Object> map) throws Exception;
}
