package com.kosta.openday.oclass.service;

import java.sql.Date;
import java.util.List;

import com.kosta.openday.oclass.dto.CategoryDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface OClassService {
	List<OClassDTO> getSearchOClass(String loc, Date startDate, Date endDate, String clsCode) throws Exception;
	}
