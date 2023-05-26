package com.kosta.openday.teacher.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.AnnouncementDTO;

@Repository
public class TeacherDAOImpl implements TeacherDAO {
	@Autowired 
	private SqlSessionTemplate sqlSession;
	
	public List<AnnouncementDTO> tcAnnouncement() {
		return sqlSession.selectList("mapper.teacherHome.tcAnnouncement");
	}
}
