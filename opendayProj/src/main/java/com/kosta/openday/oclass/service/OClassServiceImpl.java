package com.kosta.openday.oclass.service;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kosta.board.dto.FileVO;
import com.kosta.openday.oclass.dao.OClassDAO;
import com.kosta.openday.oclass.dto.OclassDTO;

@Service
public class OClassServiceImpl implements OClassService {
	
	private OClassDAO oclassDAO;

	@Override
	public void classCreate(OclassDTO dto, MultipartFile file) throws Exception {
		if(file!=null && !file.isEmpty()) {

			/* String dir = ""; */
			FileDTO fileDTO = new FileDTO();
			/* fileDTO.setDirectory(dir); */
			fileDTO.setName(file.getOriginalFilename());
			fileDTO.setSize(file.getSize());
			fileDTO.setContenttype(file.getContentType());
			fileDTO.setId(oclassDAO.newFileNum());
			fileDTO.setData(file.getBytes());
			oclassDAO.insertFile(fileDTO);
			
			File dfile = new File(fileDTO.getDirectory()+fileDTO.getId());
			file.transferTo(dfile);  //file upload
			
			dto.setFileid(fileVO.getId());
		}
		oclassDAO.classOpen(dto);
	}

}
