package com.kosta.openday.adm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.CodeDTO;

@Repository
public class CodeDAOImpl implements CodeDAO {

   @Autowired
   public SqlSessionTemplate sqlSession;
   
   @Override
   public List<CodeDTO> selectCategoryList() throws Exception { 
      return sqlSession.selectList("mapper.adm.selectCategoryList");
   }

}