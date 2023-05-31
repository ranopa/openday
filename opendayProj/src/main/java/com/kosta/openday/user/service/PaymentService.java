package com.kosta.openday.user.service;

import com.kosta.openday.user.dto.ApplicationPaymentDTO;
import com.kosta.openday.user.dto.PaymentRequestDTO;
import com.kosta.openday.user.dto.PaymentResultDTO;


public interface PaymentService {
	
	Integer doPay(PaymentRequestDTO paymentRequestDTO) throws Exception;
	
	ApplicationPaymentDTO findOne(Integer apNum) throws Exception;

	PaymentResultDTO buildPaymentResult(ApplicationPaymentDTO payment) throws Exception;
}
