package com.kosta.openday.adm.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosta.openday.adm.dto.NotificationDTO;

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
	public Integer insertNotification(NotificationDTO nDTO) throws Exception {
		sqlSession.insert("mapper.notification.insertNotification", nDTO);
		return nDTO.getNtfId();
	}

	@Override
	public List<NotificationDTO> selectNotificationListByReceiverId(String receiverId, Integer lastReceiveNumber) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("receiverId", receiverId);
		map.put("lastReceiveNumber", lastReceiveNumber);
		return sqlSession.selectList("mapper.notification.selectNotificationListByReceiverId", map);
	}
	
	
}
