package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.oclass.dto.CategoryDTO;
import com.kosta.openday.user.dto.OClassDTO;

public interface OClassDAO {
	List<CategoryDTO> selectCategoryList() throws Exception; 
	List<OClassDTO> selectOClassList(Map<String, Object> param) throws Exception;
}
