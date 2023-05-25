package com.kosta.openday.announcement.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.announcement.dto.AnnouncementDTO;

@Repository
public class AnnouncementDAOImpl implements AnnouncementDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public AnnouncementDTO selectAnnouncement(Integer ancId) throws Exception {
		return sqlSession.selectOne("mapper.announcement.selectAnnouncement", ancId);
	}

	@Override
	public List<AnnouncementDTO> selectAnnouncementList() throws Exception {
		return sqlSession.selectList("mapper.announcement.selectAnnouncementList");
	}

	@Override
	public void insertAnnouncement(AnnouncementDTO aDTO) throws Exception {
		sqlSession.insert("mapper.announcement.insertAnnouncement", aDTO);
	}

}
