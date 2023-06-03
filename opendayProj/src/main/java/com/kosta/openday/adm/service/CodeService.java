package com.kosta.openday.adm.service;

import java.util.List;

import com.kosta.openday.adm.dao.CodeDAO;

public interface CodeService {
	public List<CodeDAO> codeList(String codClassfication) throws Exception;
}
