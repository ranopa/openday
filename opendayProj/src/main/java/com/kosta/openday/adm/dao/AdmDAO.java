package com.kosta.openday.adm.dao;

import java.util.List;

import com.kosta.openday.user.dto.OClassDTO;

public interface AdmDAO {

	List<OClassDTO> selectOClassByStatus(String status) throws Exception;
}
