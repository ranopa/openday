package com.kosta.openday.adm.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.AdmInquiryDTO;
import com.kosta.openday.adm.dto.FileDTO;

@Repository
public class AdmDAOImpl implements AdmDAO {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertInquiry(AdmInquiryDTO dto) throws Exception {
		return sqlSession.insert("mapper.notice.insertAdmInquiry", dto);
	}

	@Override
	public void insertFile(FileDTO file) throws Exception {
		sqlSession.insert("mapper.amd.insertFile", file) ;	
	}

	@Override
	public Integer selectFileNum() throws Exception {
		return sqlSession.selectOne("mapper.amd.newFileId");
	}

	@Override
	public FileDTO selectFile(Integer filNum) throws Exception {
		return sqlSession.selectOne("mapper.amd.newFileId", filNum);
	}

	@Override
	public List<AdmInquiryDTO> selectInquiryList() throws Exception {
		return sqlSession.selectList("mapper.notice.selectAdmInquiryList");
	}

	@Override
	public void deleteInquiry(Integer admNum) throws Exception {
		sqlSession.delete("mapper.notice.deleteAdmInquiry", admNum);	
	}

	@Override
	public void updateInquiry(Map<String, Object> param) throws Exception {
		sqlSession.update("mapper.notice.updateAdmInquiry", param);		
	}

}
