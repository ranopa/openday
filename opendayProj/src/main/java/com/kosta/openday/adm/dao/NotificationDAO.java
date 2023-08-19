package com.kosta.openday.adm.dao;

import java.util.List;

import com.kosta.openday.adm.dto.NotificationDTO;

public interface NotificationDAO {

	public NotificationDTO selectNotification(Integer ntfId) throws Exception;
	
	public List<NotificationDTO> selectNotificationListByReceiverId(String receiverId, Integer lastReceiveNumber) throws Exception;

	public List<NotificationDTO> selectNotificationList() throws Exception;

	public Integer insertNotification(NotificationDTO nDTO) throws Exception;
}
