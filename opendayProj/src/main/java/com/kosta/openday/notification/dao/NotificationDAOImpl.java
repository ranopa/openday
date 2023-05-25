package com.kosta.openday.notification.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.notification.dto.NotificationDTO;

@Repository
public class NotificationDAOImpl implements NotificationDAO {
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public NotificationDTO selectNotification(Integer ntfNum) throws Exception {
		return sqlSession.selectOne("mapper.notification.selectNotification", ntfNum);
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
