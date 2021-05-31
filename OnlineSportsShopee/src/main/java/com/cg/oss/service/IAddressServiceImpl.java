package com.cg.oss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oss.dao.IAddressRepository;
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
public Address deleteAddress(String doorno) {
// TODO Auto-generated method stub
Optional<Address> address = addressRepo.findById(doorno);
if (!address.isPresent()) {
return new Address();
}
addressRepo.delete(address.get());
return address.get();
}

 @Override
public Address updateAddress(String doorno, Address address) {
// TODO Auto-generated method stub
Optional<Address> address1 = addressRepo.findById(doorno);
if (!address1.isPresent()) {
return new Address();
}
else {
return addressRepo.save(address);
}
}

 @Override
public Address getAddressDetails(String doorno) {
// TODO Auto-generated method stub
Optional<Address> address = addressRepo.findById(doorno);
if (!address.isPresent()) {
return new Address();
}
return address.get();
}

 @Override
public List<Address> getAllAddressDetails() {
// TODO Auto-generated method stub
return addressRepo.findAll();
}

}
