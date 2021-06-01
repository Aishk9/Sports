package com.cg.oss.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.dao.ICustomerRepository;
import com.cg.oss.service.ICustomerService;
import com.cg.oss.serviceexception.ICustomerServiceException;
import com.cg.oss.bean.Customer;
@Service
public class ICustomerServiceImpl implements ICustomerService {
@Autowired
private ICustomerRepository custRepo;

 @Override
public Customer addCustomer(Customer customer) {
// TODO Auto-generated method stub
return custRepo.save(customer);
}

 @Override
public List<Customer> getAllCustomers() {
// TODO Auto-generated method stub
return custRepo.findAll();
}

 @Override
public Customer getCustomer(String custId) throws ICustomerServiceException {
// TODO Auto-generated method stub
Optional<Customer> customer = custRepo.findById(custId);
if(!customer.isPresent()) {
	throw new ICustomerServiceException("Customer not found") ;
}
return customer.get();
}

 @Override
public Customer updateCustomer(String custId, Customer customer) throws ICustomerServiceException {
// TODO Auto-generated method stub
Optional<Customer> customer1 = custRepo.findById(custId);
if(!customer1.isPresent()) {
	throw new ICustomerServiceException("Customer not found") ;
}
return customer1.get();

}

 @Override
public Customer removeCustomer(String custId) throws ICustomerServiceException{
// TODO Auto-generated method stub
Optional<Customer> customer = custRepo.findById(custId);
if(!customer.isPresent()) {
	throw new ICustomerServiceException("Customer not found") ;
}
return customer.get();
}

}
