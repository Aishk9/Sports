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

import com.cg.oss.bean.Customer;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICustomerService;

@RestController
public class ICustomerController {
@Autowired
private ICustomerService custSer;
@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
public Customer addCustomer(@Valid @RequestBody Customer new_customer) {
return custSer.addCustomer(new_customer);
}
@RequestMapping(value="/customer/all", method=RequestMethod.GET)
public List<Customer> getAllCustomers(){
return custSer.getAllCustomers();
}
@RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
public Customer updateCustomer(@PathVariable("id") String custId,@Valid @RequestBody Customer customer) throws ResourceNotFoundException {

Customer customer1 = custSer.updateCustomer(custId, customer);
if(customer1==null)
{
throw new ResourceNotFoundException("No customers Found");
}
return customer1;

}
@RequestMapping(value = "/customer/remove/{id}", method = RequestMethod.DELETE)
public Customer removeCustomer(@PathVariable("id") String custId)throws ResourceNotFoundException {

Customer customer =custSer.removeCustomer(custId);
if(customer==null)
{
throw new ResourceNotFoundException("Not Found");
}
return customer;
}


@RequestMapping(value ="/customer/{custId}", method = RequestMethod.GET)
public Customer getCustomer(@PathVariable String custId) throws ResourceNotFoundException
{

Customer customer = custSer.getCustomer(custId);
if(customer==null)
{
throw new ResourceNotFoundException("Not Found");
}
return customer;

}

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
Map<String, String> errors = new HashMap<>();
ex.getBindingResult().getFieldErrors().forEach(error ->
errors.put(error.getField(), error.getDefaultMessage()));
return errors;
}

}