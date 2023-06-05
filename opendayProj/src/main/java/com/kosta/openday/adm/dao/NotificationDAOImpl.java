package com.kosta.openday.adm.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.user.dto.NotificationDTO;

@Repository
public class NotificationDAOImpl implements NotificationDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public NotificationDTO selectNotification(Integer ntfId) throws Exception {
		return sqlSession.selectOne("mapper.notification.selectNotification", ntfId);
	}

	@Override
	public List<NotificationDTO> selectNotificationList() throws Exception {
		return sqlSession.selectList("mapper.notification.selectNotificationList");
	}

	@Override
	public void insertNotification(NotificationDTO nDTO) throws Exception {
		sqlSession.insert("mapper.notification.insertNotification", nDTO);
	}
	
	
}
