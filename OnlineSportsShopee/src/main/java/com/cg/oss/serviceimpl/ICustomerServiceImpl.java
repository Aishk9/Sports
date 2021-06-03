package com.cg.oss.serviceimpl;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.dao.ICustomerRepository;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICustomerService;
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
public Customer getCustomer(String custId) throws ResourceNotFoundException {
// TODO Auto-generated method stub
Optional<Customer> customer = custRepo.findById(custId);
if(!customer.isPresent()) {
throw new ResourceNotFoundException("Customer not found") ;
}
return customer.get();
}

 @Override
public Customer updateCustomer(String custId, Customer customer) {

 return custRepo.save(customer);
}


 @Override
public Customer removeCustomer(String custId) throws ResourceNotFoundException{
// TODO Auto-generated method stub
Optional<Customer> customer = custRepo.findById(custId);
if(!customer.isPresent()) {
throw new ResourceNotFoundException("Customer not found") ;
}
return customer.get();
}

}