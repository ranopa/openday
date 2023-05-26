package com.kosta.openday.oclass.dao;

import java.util.List;

import com.kosta.openday.oclass.dto.CategoryDTO;

public interface OClassDAO {
	List<CategoryDTO> selectCategoryList() throws Exception; 
	
}
