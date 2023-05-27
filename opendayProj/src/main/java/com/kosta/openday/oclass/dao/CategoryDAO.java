package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import com.kosta.openday.oclass.dto.CategoryDTO;

public interface CategoryDAO {

	List<CategoryDTO> searchCategoryList(Map<String, Object> param) throws Exception;
	
}
