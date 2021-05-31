package com.cg.oss.service;

import java.util.List;

import javax.persistence.Id;

import com.cg.oss.bean.Address;

public interface IAddressService {
public Address addAddress(Address address);
public Address deleteAddress(String doorno) throws IAddressServiceException;
public Address updateAddress(String doorno, Address address) throws IAddressServiceException;
public Address getAddressDetails(String doorno) throws IAddressServiceException;
public List<Address> getAllAddressDetails();
}
