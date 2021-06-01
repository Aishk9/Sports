package com.cg.oss.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Payment;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IPaymentService;
import com.cg.oss.serviceexception.IPaymentServiceException;


@RestController
public class IPaymentController {

	@Autowired
	private IPaymentService payService;
	
	@RequestMapping(value="/payment/all", method=RequestMethod.GET)
   public List<Payment> getAllPaymentDetails(){
		
		return payService.getAllPaymentDetails();
	}
	
	@RequestMapping(value= "/payment/{paymentId}", method= RequestMethod.GET)
    public Payment getPaymentDetails(@PathVariable long paymentId) throws ResourceNotFoundException,IPaymentServiceException {
		
		try {
			Payment payment = payService.getPaymentDetails(paymentId);
			if(payment==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment;
		}catch(IPaymentServiceException e) {
			throw new IPaymentServiceException("No Payment Found");
		}
		
	}
	
	@RequestMapping(value= "/payment/add", method= RequestMethod.POST)
	public Payment addPayment(@RequestBody Payment newpay) {       
	        return payService.addPayment(newpay);
	}
	
	@RequestMapping(value= "/payment/update/{paymentId}", method= RequestMethod.PUT)
    public Payment updatePayment(@RequestBody Payment updpay, @PathVariable long paymentId) throws ResourceNotFoundException,IPaymentServiceException{
        
		try {
			Payment payment = payService.getPaymentDetails(paymentId);
			if(payment==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment;
		}catch(IPaymentServiceException e) {
			throw new IPaymentServiceException("No Payment Found");
		}
		
		
}
	
	
	@RequestMapping(value= "/payment/delete/{paymentId}", method= RequestMethod.DELETE)
	public Payment deletePayment(@PathVariable long paymentId) throws ResourceNotFoundException,IPaymentServiceException {

		try {
			Payment payment = payService.getPaymentDetails(paymentId);
			if(payment==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment;
		}catch(IPaymentServiceException e) {
			throw new IPaymentServiceException("No Payment Found");
		}
		
	

	}
		
}

