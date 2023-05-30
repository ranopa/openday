package com.kosta.openday.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.openday.user.dao.PaymentDAO;
import com.kosta.openday.user.dto.ApplicationPaymentDTO;
import com.kosta.openday.user.dto.PaymentRequestDTO;
import com.kosta.openday.user.dto.PaymentResultDTO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Override
	public PaymentResultDTO doPay(PaymentRequestDTO paymentRequestDTO) throws Exception {
		ApplicationPaymentDTO payment = new ApplicationPaymentDTO();
		// payment 세팅. pk랑 시간 빼고 나머지는 request에서 뽑아서
		paymentDAO.insertApplicationPayment(payment);
		
		PaymentResultDTO result = new PaymentResultDTO(); // 얘는 request랑 비슷, 성공실패까지
		return result;
	}

}
