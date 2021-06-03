package com.cg.oss.service;

import java.util.List;

import javax.persistence.Id;

import com.cg.oss.bean.Address;
import com.cg.oss.exception.ResourceNotFoundException;


public interface IAddressService {
public Address addAddress(Address address);
public Address deleteAddress(String doorno) throws ResourceNotFoundException;
public Address updateAddress(String doorno, Address address) throws ResourceNotFoundException;
public Address getAddressDetails(String doorno) throws ResourceNotFoundException;
public List<Address> getAllAddressDetails();
}
