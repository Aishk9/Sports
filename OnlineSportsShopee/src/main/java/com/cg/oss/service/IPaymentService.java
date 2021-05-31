package com.cg.oss.service;
import java.util.List;


import com.cg.oss.bean.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);
	public Payment deletePayment(long paymentId) throws IPaymentServiceException;
	public Payment updatePayment(long paymentId, Payment payment) throws IPaymentServiceException;
	public Payment getPaymentDetails(long paymentId) throws IPaymentServiceException;
	public List<Payment> getAllPaymentDetails();
//	public Optional<Payment> getPayment(long paymentId);
}
