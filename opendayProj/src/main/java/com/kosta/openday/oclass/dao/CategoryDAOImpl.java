package com.kosta.openday.oclass.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.oclass.dto.CategoryDTO;
@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<CategoryDTO> searchCategoryList() throws Exception {
		return sqlSession.selectList("mapper.oclass.categoryList");
	}

}

