package com.kosta.openday.adm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kosta.openday.adm.service.NotificationService;

@Controller
public class NotificationController {

	@Autowired
	private NotificationService notificationService;
}
