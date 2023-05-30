package com.kosta.openday.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.user.dto.PaymentRequestDTO;
import com.kosta.openday.user.dto.PaymentResultDTO;

public interface PaymentService {
	
	PaymentResultDTO doPay(PaymentRequestDTO paymentRequestDTO) throws Exception;
}
