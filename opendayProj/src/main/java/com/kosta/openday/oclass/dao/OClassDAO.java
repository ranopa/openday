package com.kosta.openday.oclass.dao;

import java.util.List;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.oclass.dto.CategoryDTO;
import com.kosta.openday.oclass.dto.OClassDTO;
import com.kosta.openday.oclass.dto.ScheduleDTO;

@Repository
public interface OClassDAO {
	List<CategoryDTO> selectCategoryList() throws Exception; 
}
