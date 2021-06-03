package com.cg.oss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Payment;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IPaymentService;



@RestController
public class IPaymentController {

	@Autowired
	private IPaymentService payService;
	
	@RequestMapping(value="/payment/all", method=RequestMethod.GET)
   public List<Payment> getAllPaymentDetails(){
		
		return payService.getAllPaymentDetails();
	}
	
	@RequestMapping(value= "/payment/{paymentId}", method= RequestMethod.GET)
    public Payment getPaymentDetails(@PathVariable long paymentId) throws ResourceNotFoundException {
		
		try {
			Payment payment = payService.getPaymentDetails(paymentId);
			if(payment==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment;
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("No Payment Found");
		}
		
	}
	
	@RequestMapping(value= "/payment/add", method= RequestMethod.POST)
	public Payment addPayment(@Valid @RequestBody Payment newpay) {       
	        return payService.addPayment(newpay);
	}
	
	@RequestMapping(value= "/payment/update/{paymentId}", method= RequestMethod.PUT)
	public Payment updatePayment(@PathVariable("paymentId")  long paymentId,@Valid @RequestBody Payment payment) throws ResourceNotFoundException {
        
	
		
		try {
			Payment payment1 = payService.updatePayment(paymentId, payment);
			if(payment1==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment1;
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("No Payment Found");
		}
		
		
}
	
	
	@RequestMapping(value= "/payment/delete/{paymentId}", method= RequestMethod.DELETE)
	public Payment deletePayment(@PathVariable("paymentId") long paymentId) throws ResourceNotFoundException {

		try {
			Payment payment = payService.deletePayment(paymentId);
			if(payment==null) {
				throw new ResourceNotFoundException("Not Found");
			}
			return payment;
		}catch(ResourceNotFoundException e) {
			throw new ResourceNotFoundException("No Payment Found");
		}
		
	

	}
	
//to display error messages to client

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
     
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
         
        return errors;
    }

}	// end of the controller class

	
	
		


