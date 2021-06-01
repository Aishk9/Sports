package com.cg.oss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Address;
import com.cg.oss.service.IAddressService;
import com.cg.oss.serviceexception.IAddressServiceException;


@RestController
public class IAddressController {
@Autowired

 private IAddressService addressService;
@RequestMapping(value= "/address/add", method= RequestMethod.POST)
public Address addAddress(@RequestBody Address address){
return addressService.addAddress(address);
}
@RequestMapping(value = "/address/delete/{id}", method = RequestMethod.DELETE)
public Address deleteAddress(@PathVariable("id") String doorNo) throws IAddressServiceException{
return addressService.deleteAddress(doorNo);
}
@RequestMapping(value="/address/update/{id}", method = RequestMethod.PUT)
public Address updateAddress(@PathVariable("id") String doorNo, @RequestBody Address address) throws IAddressServiceException
{
return addressService.updateAddress(doorNo, address);
}
@RequestMapping(value="/address/get/{id}", method=RequestMethod.GET)
public Address getAddressDetails(@PathVariable("id") String doorNo) throws IAddressServiceException {
return addressService.getAddressDetails(doorNo);
}
@RequestMapping(value="/address/all", method=RequestMethod.GET)
public List<Address> getAllAddressDetails()
{
return addressService.getAllAddressDetails();
}

}