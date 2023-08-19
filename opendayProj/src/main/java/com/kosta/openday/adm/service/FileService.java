package com.kosta.openday.adm.service;

import com.kosta.openday.adm.dto.FileDTO;

public interface FileService {
	void createFile(FileDTO file)throws Exception;
	FileDTO searchFile(Integer filNum) throws Exception;
}
package com.kosta.openday.adm.service;

import org.springframework.web.multipart.MultipartFile;

import com.kosta.openday.adm.dto.FileDTO;

public interface FileService {
	Integer createFile(MultipartFile file) throws Exception;
}