package com.cg.oss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.bean.Payment;
import com.cg.oss.dao.IPaymentRepository;




@Service
public class IPaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private IPaymentRepository payRepo;

	@Override
	public Payment addPayment(Payment payment) {
	
		return payRepo.save(payment);
	}

	@Override
	public Payment deletePayment(long paymentId) {
        Optional<Payment> payment =  payRepo.findById(paymentId);
        if(!payment.isPresent()) {
            return new Payment();
        }
        payRepo.delete(payment.get());
        return payment.get();
    }

	@Override
	public Payment updatePayment(long paymentId, Payment payment) {
	
		return payRepo.save(payment);
	}

	@Override
	public Payment getPaymentDetails(long paymentId) {
		Optional<Payment> payment =  payRepo.findById(paymentId);
        if(!payment.isPresent()) {
            return new Payment();
        }
        return payment.get();
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return payRepo.findAll();
	}

	
}
