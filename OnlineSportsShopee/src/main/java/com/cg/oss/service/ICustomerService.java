package com.cg.oss.service;

import java.util.List;

import com.cg.oss.bean.Customer;
import com.cg.oss.serviceexception.ICustomerServiceException;

public interface ICustomerService {
public Customer addCustomer(Customer customer);
public Customer removeCustomer(String custId) throws ICustomerServiceException;
public Customer updateCustomer(String custId, Customer customer) throws ICustomerServiceException;
public Customer getCustomer(String custId) throws ICustomerServiceException;
public List<Customer> getAllCustomers();

}
