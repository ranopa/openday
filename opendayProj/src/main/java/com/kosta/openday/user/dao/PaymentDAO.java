package com.kosta.openday.user.dao;

import java.util.List;

import com.kosta.openday.user.dto.ApplicationPaymentDTO;

public interface PaymentDAO {
	
	ApplicationPaymentDTO selectApplicationPaymentByClsId(Integer clsId) throws Exception;
	ApplicationPaymentDTO selectApplicationPaymentByUserId(String userId) throws Exception;
	ApplicationPaymentDTO selectApplicationPayment(Integer num) throws Exception;
	
	List<ApplicationPaymentDTO> selectApplicationPaymentList() throws Exception;
	
	void insertApplicationPayment(ApplicationPaymentDTO dto) throws Exception;
}
