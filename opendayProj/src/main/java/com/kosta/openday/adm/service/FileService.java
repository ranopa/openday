package com.kosta.openday.adm.service;

import com.kosta.openday.adm.dto.FileDTO;

public interface FileService {
	void createFile(FileDTO file)throws Exception;
}
