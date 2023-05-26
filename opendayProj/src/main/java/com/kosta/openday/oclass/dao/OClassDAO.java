package com.kosta.openday.oclass.dao;

import com.kosta.openday.oclass.dto.OclassDTO;

public interface OClassDAO {
	public int classOpen(OclassDTO dto) throws Exception;
	//public void insertFile(FileVO file) throws Exception;
}
