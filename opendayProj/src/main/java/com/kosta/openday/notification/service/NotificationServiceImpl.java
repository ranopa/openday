package com.kosta.openday.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.notification.dao.NotificationDAO;

@Service
public class NotificationServiceImpl {
	
	@Autowired
	private NotificationDAO notificationDAO;
}
