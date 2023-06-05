package com.kosta.openday.adm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.CodeDAO;

import com.kosta.openday.adm.dto.CodeDTO;

@Service
public class CodeServiceImpl implements CodeService {


   @Autowired
   private CodeDAO codeDAO;
   
   @Override
	public List<CodeDTO> codeList(String codClassfication) throws Exception {
		return codeDAO.codeList(codClassfication);
	}
   
   @Override
   public List<CodeDTO> categoryInfoList() throws Exception { 
      return codeDAO.selectCategoryList();
   }

}
