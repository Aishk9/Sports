package com.cg.oss.service;


import static org.junit.jupiter.api.Assertions.*;   
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Optional;   import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oss.bean.Customer;
import com.cg.oss.bean.Payment;
import com.cg.oss.serviceexception.ICustomerServiceException;
import com.cg.oss.serviceexception.IPaymentServiceException;   
@SpringBootTest
public class CustomerServiceTest {      
	@Autowired

    ICustomerService custSer;    
	
	   DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    LocalDate date = LocalDate.parse("11/07/1999", format);
	@Test

    void testFindAllCustomer() {

        List<Customer> Customers = custSer.getAllCustomers();

        assertEquals(3, Customers.size());

    }

    // findPaymentById      
	
	@Test

    void testFindCustomerById() throws ICustomerServiceException {

        Customer customer = custSer.getCustomer("113");

       
assertEquals("113",customer.getUserId());

        assertEquals("Dhivya",customer.getName());


    }    
	// addEmployee

    @Test

    void testCreateCustomer() {

    	Customer customer = new Customer("104", "Abhisek", "abhisek78@gmail.com","7008089071",date);
    Customer persistedCust = custSer.addCustomer(customer);   
  assertEquals("106", persistedCust.getUserId());

        assertEquals("Abhisek", persistedCust.getName());

        assertEquals("abhisek78@gmail.com", persistedCust.getEmail());
assertEquals("7008089071", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());

    }       @Test

    void testUpdateCustomer() throws ICustomerServiceException {

        Customer Customer = new Customer("104", "Surbhi", "surbhi8768@gmail.com","7007542271",date);
         

        Customer persistedCust = custSer.updateCustomer("104", Customer);
         

 assertEquals("104", persistedCust.getUserId());


 assertEquals("Abhisek", persistedCust.getName());

 assertEquals("abhisek78@gmail.com", persistedCust.getEmail());
assertEquals("7008089071", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());
    }      
    @Test

    void testDeleteCustomer() throws ICustomerServiceException {

        Customer Customer = new Customer("104", "Surbhi", "surbhi8768@gmail.com","7007542271",date);
        

           custSer.removeCustomer("104");

        Customer persistedCust = custSer.removeCustomer("104");
        assertEquals("Abhisek", persistedCust.getName());

        assertEquals("abhisek78@gmail.com", persistedCust.getEmail());
}  }