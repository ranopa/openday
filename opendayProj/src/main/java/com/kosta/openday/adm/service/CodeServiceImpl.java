package com.kosta.openday.adm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.CodeDAO;

@Service
public class CodeServiceImpl implements CodeService {
	@Autowired
	private CodeDAO codeDAO;
	@Override
	public List<CodeDAO> codeList(String codClassfication) throws Exception {
		return codeDAO.codeList(codClassfication);
	}
	
}
