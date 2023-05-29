
package com.kosta.openday.oclass.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.oclass.dao.CategoryDAO;
import com.kosta.openday.oclass.dto.CategoryDTO;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Override
	public List<CategoryDTO> getCategory() throws Exception{
		
		return categoryDAO.searchCategoryList();
		
	}

}
