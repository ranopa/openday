package com.kosta.openday.adm.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.openday.adm.dto.NotificationDTO;
import com.kosta.openday.adm.dto.NotificationSourceType;
import com.kosta.openday.adm.service.NotificationService;

@Controller
public class NotificationController {
	@Autowired
	ServletContext context;

	@Autowired
	private NotificationService notiService;
	
	@RequestMapping("/notification")
	public void notification() {
		try {
			Integer srcType = 5; // 클래스 개설 
			Integer srcId = 1; // 클래스 번호 
			Integer returnId = notiService.createNotification(srcId, NotificationSourceType.OCLASS_APPLY_DONE, "myclass", "0000", "sbsb");
			NotificationDTO noti = notiService.findOne(returnId);
			System.out.println(noti.getNtfMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	// 유저정보(receiver), 마지막 알림번호 전달하면 알림반환 
	@RequestMapping("/notification/{userId}")
	public void getNotification(
			@PathVariable("userId") String receiverId, 
			@RequestParam(value="lastReceiveNumber", required=false, defaultValue = "0") Integer lastReceiveNumber) {
		try {
			List<NotificationDTO> notiList = notiService.findByReceiver(receiverId, lastReceiveNumber);
			
			for(NotificationDTO noti: notiList) {
				System.out.println("msg"+ noti.getNtfMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
