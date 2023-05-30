package com.kosta.openday.user.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.kosta.openday.user.dto.ApplicationPaymentDTO;

public class PaymentDAOImpl implements PaymentDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public ApplicationPaymentDTO selectApplicationPayment(Integer apNum) throws Exception {
		return sqlSession.selectOne("mapper.payment.selectApplicationPayment", apNum);
	}
	
	@Override
	public ApplicationPaymentDTO selectApplicationPaymentByClsId(Integer clsId) throws Exception {
		return sqlSession.selectOne("mapper.payment.selectApplicationPaymentByClsId", clsId);
	}

	@Override
	public ApplicationPaymentDTO selectApplicationPaymentByUserId(String userId) throws Exception {
		return sqlSession.selectOne("mapper.payment.selectApplicationPaymentByUserId", userId);
	}

	@Override
	public List<ApplicationPaymentDTO> selectApplicationPaymentList() throws Exception {
		return sqlSession.selectList("mapper.payment.selectApplicationPaymentList");
	}
	
	@Override
	public void insertApplicationPayment(ApplicationPaymentDTO dto) throws Exception {
		sqlSession.insert("mapper.payment.insertApplicationPayment", dto);
	}

}
