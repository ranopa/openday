package com.kosta.openday.adm.service;

import java.util.List;

import com.kosta.openday.adm.dto.NotificationDTO;
import com.kosta.openday.adm.dto.NotificationSourceType;

public interface NotificationService {
	NotificationDTO findOne(Integer returnId) throws Exception;
	
	List<NotificationDTO> findAll() throws Exception;
	
	List<NotificationDTO> findByReceiver(String receiverId, Integer lastReceiveNumber) throws Exception;
	
	Integer createNotification(Integer srcId, NotificationSourceType srcType, 
			String srcName, String senderId, String receiverId) throws Exception;
}