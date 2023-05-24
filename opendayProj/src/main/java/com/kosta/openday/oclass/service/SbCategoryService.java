package com.kosta.openday.oclass.service;

import java.util.List;

import com.kosta.openday.oclass.dto.CategoryDTO;

public interface SbCategoryService {
	List<CategoryDTO> getCategoryList()throws Exception;
}
