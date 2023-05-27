package com.kosta.openday.oclass.service;

import java.util.List;

import com.kosta.openday.oclass.dto.CategoryDTO;

public interface CategoryService {
	List<CategoryDTO> getCategory(String codNum, String codClassfication, String codName) throws Exception;

}
