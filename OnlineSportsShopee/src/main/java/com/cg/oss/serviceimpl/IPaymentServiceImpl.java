package com.cg.oss.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.bean.Payment;
import com.cg.oss.dao.IPaymentRepository;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IPaymentService;




@Service
public class IPaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private IPaymentRepository payRepo;

	@Override
	public Payment addPayment(Payment payment) {
	
		return payRepo.save(payment);
	}

	@Override
	public Payment deletePayment(long paymentId) throws ResourceNotFoundException {
        Optional<Payment> payment =  payRepo.findById(paymentId);
        if(!payment.isPresent()) {
        	throw new ResourceNotFoundException("Payment not present") ;
        }
        payRepo.delete(payment.get());
        return payment.get();
    }

	@Override
	public Payment updatePayment(long paymentId, Payment payment) {
	
		return payRepo.save(payment);
	}

	@Override
	public Payment getPaymentDetails(long paymentId) throws ResourceNotFoundException {
		Optional<Payment> payment =  payRepo.findById(paymentId);
        if(!payment.isPresent()) {
        	throw new ResourceNotFoundException("Payment not present") ;
        }
        return payment.get();
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		return payRepo.findAll();
	}

	
}
