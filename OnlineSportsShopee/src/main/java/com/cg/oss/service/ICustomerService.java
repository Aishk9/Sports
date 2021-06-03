package com.cg.oss.service;

import java.util.List;

import com.cg.oss.bean.Customer;
import com.cg.oss.exception.ResourceNotFoundException;


public interface ICustomerService {
public Customer addCustomer(Customer customer);
public Customer removeCustomer(String custId) throws ResourceNotFoundException;
public Customer updateCustomer(String custId, Customer customer) throws ResourceNotFoundException;
public Customer getCustomer(String custId) throws ResourceNotFoundException;
public List<Customer> getAllCustomers();

}
