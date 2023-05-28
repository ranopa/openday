package com.kosta.openday.adm.dao;

import com.kosta.openday.adm.dto.FileDTO;

public interface FileDAO {
	void insertFile(FileDTO file)throws Exception;
	FileDTO selectFile(Integer fileId) throws Exception;
	Integer selectNewFileId() throws Exception;
	
	

}
