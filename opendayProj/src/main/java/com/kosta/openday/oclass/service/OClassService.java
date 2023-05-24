package com.kosta.openday.oclass.service;

import java.util.List;

import com.kosta.openday.oclass.dto.OClassDTO;

public interface OClassService {
	
	public OClassDTO findOne(String id) throws Exception;
	
	public List<OClassDTO> findAll() throws Exception;
	
	public void save(OClassDTO dto) throws Exception;
	
	// todo: update, delete
	
}
