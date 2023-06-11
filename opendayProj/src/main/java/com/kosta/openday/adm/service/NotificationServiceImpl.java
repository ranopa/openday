package com.kosta.openday.adm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.adm.dao.NotificationDAO;
import com.kosta.openday.adm.dto.NotificationDTO;
import com.kosta.openday.adm.dto.NotificationSourceType;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	private NotificationDAO notificationDAO;
	
	public NotificationServiceImpl() {}

	@Override
	public Integer createNotification(Integer srcId, NotificationSourceType srcType, 
			String srcName, String senderId, String receiverId) throws Exception {
		NotificationDTO noti = new NotificationDTO();
		noti.setNtfSourceId(srcId);
		noti.setNtfSourceType(srcType.getType());
		noti.setNtfMessage(srcType.buildMessage(srcName));
		noti.setNtfIsRead(false);
		noti.setNtfIsDeleted(false);
		noti.setNtfUrl(srcType.getTargetUrl(srcId));
		noti.setNtfSenderId(senderId);
		noti.setNtfReceiverId(receiverId);
		
		Integer id = notificationDAO.insertNotification(noti); // todo
		return id;
	}

	@Override
	public NotificationDTO findOne(Integer returnId) throws Exception {
		return notificationDAO.selectNotification(returnId);
	}

	@Override
	public List<NotificationDTO> findAll() throws Exception {
		// TODO Auto-generated method stub
		return notificationDAO.selectNotificationList();
	}

	@Override
	public List<NotificationDTO> findByReceiver(String receiverId, Integer lastReceiveNumber) throws Exception {
		return notificationDAO.selectNotificationListByReceiverId(receiverId, lastReceiveNumber);
	}

}
