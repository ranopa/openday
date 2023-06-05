package com.kosta.openday.adm.dao;

import java.util.List;

import com.kosta.openday.adm.dto.CodeDTO;

public interface CodeDAO {
	public List<CodeDTO> codeList(String codClassfication) throws Exception;

	public List<CodeDTO> selectCategoryList() throws Exception;
}
