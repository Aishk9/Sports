package com.cg.oss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oss.bean.Address;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IAddressService;

@RestController
public class IAddressController {
@Autowired

 private IAddressService addressService;
@RequestMapping(value= "/address/add", method = RequestMethod.POST)
public Address addAddress(@Valid @RequestBody Address address){
return addressService.addAddress(address);
}
@RequestMapping(value = "/address/delete/{id}", method = RequestMethod.DELETE)
public Address deleteAddress(@PathVariable("id") String doorNo) throws ResourceNotFoundException{
return addressService.deleteAddress(doorNo);
}
@RequestMapping(value="/address/update/{id}", method = RequestMethod.PUT)
public Address updateAddress(@PathVariable("id") String doorNo,@Valid @RequestBody Address address) throws ResourceNotFoundException
{
return addressService.updateAddress(doorNo, address);
}
@RequestMapping(value="/address/get/{id}", method=RequestMethod.GET)
public Address getAddressDetails(@PathVariable("id") String doorNo) throws ResourceNotFoundException {
return addressService.getAddressDetails(doorNo);
}
@RequestMapping(value="/address/all", method=RequestMethod.GET)
public List<Address> getAllAddressDetails()
{
return addressService.getAllAddressDetails();
}

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ExceptionHandler(MethodArgumentNotValidException.class)
public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
Map<String, String> errors = new HashMap<>();

 ex.getBindingResult().getFieldErrors().forEach(error ->
errors.put(error.getField(), error.getDefaultMessage()));
return errors;
}
}