package com.kosta.openday.adm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.NotificationDAO;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDAO notificationDAO;
	
	public NotificationServiceImpl() {}
}
