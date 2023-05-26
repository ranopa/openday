package com.kosta.openday.oclass.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.oclass.dto.CategoryDTO;

@Repository
public class OClassDAOImpl implements OClassDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<CategoryDTO> selectCategoryList() throws Exception { 
		List<CategoryDTO> list = sqlSession.selectList("mapper.oclass.selectCategoryList");
		System.out.println(list.isEmpty());
		return list; 
	}
	
}
