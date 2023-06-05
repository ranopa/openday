package com.kosta.openday.adm.service;

import java.util.List;

import com.kosta.openday.adm.dto.CodeDTO;

public interface CodeService {
	public List<CodeDTO> codeList(String codClassfication) throws Exception;

	public List<CodeDTO> categoryInfoList() throws Exception;
}
