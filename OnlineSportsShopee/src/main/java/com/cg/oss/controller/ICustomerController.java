package com.cg.oss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Customer;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICustomerService;
import com.cg.oss.serviceexception.ICustomerServiceException;


@RestController
public class ICustomerController {
@Autowired
private ICustomerService custSer;
@RequestMapping(value = "/customer/add", method = RequestMethod.POST)
public Customer addCustomer(@RequestBody Customer new_customer) {
return custSer.addCustomer(new_customer);
}
@RequestMapping(value="/customer/all", method=RequestMethod.GET)
public List<Customer> getAllCustomers(){
return custSer.getAllCustomers();
}
@RequestMapping(value = "/customer/update/{id}", method = RequestMethod.PUT)
public Customer updateCustomer(@PathVariable("id") String custId, @RequestBody Customer customer) throws ResourceNotFoundException,ICustomerServiceException {
try
{
Customer customer1 = custSer.updateCustomer(custId, customer);
if(customer1==null)
{
throw new ResourceNotFoundException("No customers Found");
}
return customer1;
}
catch(ICustomerServiceException e)
{
throw new ICustomerServiceException("No customers found");
}
}
@RequestMapping(value = "/customer/remove/{id}", method = RequestMethod.DELETE)
public Customer removeCustomer(@PathVariable("id") String custId)throws ResourceNotFoundException,ICustomerServiceException {
try
{
Customer customer =custSer.removeCustomer(custId);
if(customer==null)
{
throw new ResourceNotFoundException("Not Found");
}
return customer;
}
catch(ICustomerServiceException e)
{
throw new ICustomerServiceException("No customers Found");
}
}
@RequestMapping(value ="/customer/{custId}", method = RequestMethod.GET)
public Customer getCustomer(@PathVariable String custId) throws ResourceNotFoundException,ICustomerServiceException
{
try {
Customer customer = custSer.getCustomer(custId);
if(customer==null)
{
throw new ResourceNotFoundException("Not Found");
}
return customer;
}
catch(ICustomerServiceException e) {
throw new ICustomerServiceException("No Customers Found");
}
}

}
