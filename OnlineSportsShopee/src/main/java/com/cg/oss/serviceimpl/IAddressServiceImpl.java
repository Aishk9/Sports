package com.cg.oss.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.dao.IAddressRepository;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IAddressService;
import com.cg.oss.bean.Address;
@Service

public class IAddressServiceImpl implements IAddressService{

 @Autowired
private IAddressRepository addressRepo;
@Override
public Address addAddress(Address address) {
// TODO Auto-generated method stub
return addressRepo.save(address);
}

 @Override
public Address deleteAddress(String doorno) throws ResourceNotFoundException {
// TODO Auto-generated method stub
Optional<Address> address = addressRepo.findById(doorno);
if (!address.isPresent()) {
throw new ResourceNotFoundException("No Address Details Found for Deletion ");
}
addressRepo.delete(address.get());
return address.get();
}

 @Override
public Address updateAddress(String doorno, Address address) throws ResourceNotFoundException {
// TODO Auto-generated method stub
Optional<Address> address1 = addressRepo.findById(doorno);
if (!address1.isPresent()) {
throw new ResourceNotFoundException("No Address Details Found ");
}
else {
return addressRepo.save(address);
}
}

 @Override
public Address getAddressDetails(String doorno) throws ResourceNotFoundException {
// TODO Auto-generated method stub
Optional<Address> address = addressRepo.findById(doorno);
if (!address.isPresent()) {
throw new ResourceNotFoundException("No Address Details Found ");
}
return address.get();
}

 @Override
public List<Address> getAllAddressDetails() {
// TODO Auto-generated method stub
return addressRepo.findAll();
}

}