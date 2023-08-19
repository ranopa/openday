package com.kosta.openday.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kosta.openday.teacher.dto.ScheduleDTO;
import com.kosta.openday.user.dao.PaymentDAO;
import com.kosta.openday.user.dto.ApplicationPaymentDTO;
import com.kosta.openday.user.dto.OClassDTO;
import com.kosta.openday.user.dto.PaymentRequestDTO;
import com.kosta.openday.user.dto.PaymentResultDTO;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDAO paymentDAO;
	
	@Autowired
	private OClassService oClassService;
	
	@Override
	public Integer calculateFinalAmount(PaymentRequestDTO request) throws Exception {
		OClassDTO oClass = oClassService.findOne(request.getClsId());
		
		Integer discounted = applyDiscount(oClass.getClsPrice(), oClass.getClsDiscount());
		return discounted - request.getPoint();
	}
	
	@Override
	public Integer applyDiscount(Integer baseAmount, Integer discountPercent) {
		Double discountedPrice = 
				(double)baseAmount * (1 - (double)discountPercent/100);
		
		return Math.toIntExact(Math.round(discountedPrice));
	}

	
	@Transactional
	@Override
	public Integer doPay(PaymentRequestDTO paymentRequest) throws Exception {
			
		Integer finalAmount = calculateFinalAmount(paymentRequest);
		// todo: user point 검증 나중에 추가(front,back모두)
		String userId = paymentRequest.getUserId();
		
		// 수강신청번호:auto, 결제일: curdate
		ApplicationPaymentDTO payment = new ApplicationPaymentDTO();
	
		// todo: 결제성공/실패 별도 코드 추가
		payment.setApPstatus("정상"); // 결제상태
		payment.setApAstatus("수강예정"); // 수강상태
		payment.setApPgProvider(paymentRequest.getPgProvider());
		payment.setApMethod(paymentRequest.getPaymentMethodName());
		payment.setApFinalAmount(finalAmount);
		payment.setScdNum(paymentRequest.getScdNum());
		payment.setUserId(userId);
		
		// payment 세팅. pk랑 시간 빼고 나머지는 request에서 뽑아서
		paymentDAO.insertApplicationPayment(payment);
		return paymentDAO.selectLastInsertedPaymentNum();
	}

	@Override
	public ApplicationPaymentDTO findOne(Integer apNum) throws Exception {
		return paymentDAO.selectApplicationPayment(apNum);
	}

	@Override
	public PaymentResultDTO buildPaymentResult(ApplicationPaymentDTO payment) throws Exception {
		PaymentResultDTO paymentResult = new PaymentResultDTO();
		
		ScheduleDTO schedule = oClassService.findScheduleById(payment.getScdNum());
		OClassDTO oClass = oClassService.findOne(schedule.getClsId());
		
		paymentResult.setApNum(payment.getApNum());
		paymentResult.setApPstatus(payment.getApPstatus());
		paymentResult.setApPgProvider(payment.getApPgProvider());
		paymentResult.setApMethod(payment.getApMethod());
		paymentResult.setApFinalAmount(payment.getApFinalAmount());
		paymentResult.setApDate(payment.getApDate());
		
		paymentResult.setoClass(oClass);
		paymentResult.setSchedule(schedule);
		
		paymentResult.setUserId(payment.getUserId());
		
		return paymentResult;
	}
}
