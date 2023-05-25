package com.kosta.openday.notification.dao;

import java.util.List;

import com.kosta.openday.notification.dto.NotificationDTO;

public interface NotificationDAO {
	
	public NotificationDTO selectNotification(Integer ntfNum) throws Exception;
	public List<NotificationDTO> selectNotificationList() throws Exception;
	public void insertNotification(NotificationDTO nDTO) throws Exception;
}
