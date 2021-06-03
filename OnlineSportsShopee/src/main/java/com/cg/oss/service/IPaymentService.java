package com.cg.oss.service;
import java.util.List;


import com.cg.oss.bean.Payment;
import com.cg.oss.exception.ResourceNotFoundException;


public interface IPaymentService {
	public Payment addPayment(Payment payment);
	public Payment deletePayment(long paymentId) throws ResourceNotFoundException;
	public Payment updatePayment(long paymentId, Payment payment) throws ResourceNotFoundException;
	public Payment getPaymentDetails(long paymentId) throws ResourceNotFoundException;
	public List<Payment> getAllPaymentDetails();
//	public Optional<Payment> getPayment(long paymentId);
}
