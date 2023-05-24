package com.kosta.openday.oclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.oclass.dao.SbCategoryDAO;
import com.kosta.openday.oclass.dto.CategoryDTO;

@Service
public class SbCategoryServiceImpl implements SbCategoryService{

	@Autowired
	private SbCategoryDAO cateDAO;

	@Override
	public List<CategoryDTO> getCategoryList() throws Exception { 
		return cateDAO.selectCategoryList(); 
	} 
	 
}
