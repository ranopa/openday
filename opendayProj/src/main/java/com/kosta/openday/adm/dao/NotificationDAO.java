package com.kosta.openday.adm.dao;

import java.util.List;

import com.kosta.openday.user.dto.NotificationDTO;

public interface NotificationDAO {
	
	public NotificationDTO selectNotification(Integer ntfId) throws Exception;
	public List<NotificationDTO> selectNotificationList() throws Exception;
	public void insertNotification(NotificationDTO nDTO) throws Exception;
}