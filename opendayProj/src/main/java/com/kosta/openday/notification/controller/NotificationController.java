package com.kosta.openday.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kosta.openday.notification.service.NotificationService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
}
