package com.kosta.openday.adm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kosta.openday.adm.dto.NotificationDTO;
import com.kosta.openday.adm.service.NotificationService;

@Controller
public class NotificationController {
	@Autowired
	ServletContext context;

	@Autowired
	private NotificationService notiService;
	
	// 유저정보(receiver), 마지막 알림번호 전달하면 알림반환 
	@RequestMapping("/notification/{userId}")
	@ResponseBody
	public List<NotificationDTO> getNotification(
			@PathVariable("userId") String receiverId, 
			@RequestParam(value="lastReceiveNumber", required=false, defaultValue = "0") Integer lastReceiveNumber) {

		List<NotificationDTO> notiList = new ArrayList<>();
		try {
			notiList = notiService.findByReceiver(receiverId, lastReceiveNumber);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notiList;
	}
	
	// 알림 삭제 -- 미구현 
	@RequestMapping("/deletealarm")
	public void deleteNotification(@RequestBody String id) {
		System.out.println(id);
	}
}
