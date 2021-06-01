package com.cg.oss.service;


import static org.junit.jupiter.api.Assertions.*;   import java.time.LocalDate;

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
	@Test

    void testFindAllCustomer() {

        List<Customer> Customers = custSer.getAllCustomers();

        assertEquals(3, Customers.size());

    }

    // findPaymentById      
	
	@Test

    void testFindCustomerById() throws ICustomerServiceException {

        Customer customer = custSer.getCustomer("105");

       
assertEquals("105",customer.getUserId());

        assertEquals("Abhinabh",customer.getName());

        assertEquals("abhinabh46@gmail.com",customer.getEmail());
assertEquals("7008976321", customer.getContactNo());
assertEquals(LocalDate.parse("1996/04/11"), customer.getDob());

    }    
	// addEmployee

    @Test

    void testCreateCustomer() {

    	Customer customer = new Customer("106", "Abhisek", "abhisek78@gmail.com","7008089071",LocalDate.parse("1995/08/11"));
    Customer persistedCust = custSer.addCustomer(customer);   
  assertEquals("106", persistedCust.getUserId());

        assertEquals("Abhisek", persistedCust.getName());

        assertEquals("abhisek78@gmail.com", persistedCust.getEmail());
assertEquals("7008089071", persistedCust.getContactNo());
assertEquals(LocalDate.parse("1995/08/11"), persistedCust.getDob());

    }       @Test

    void testUpdateCustomer() throws ICustomerServiceException {

        Customer Customer = new Customer("108", "Surbhi", "surbhi8768@gmail.com","7007542271",LocalDate.parse("1999/02/12"));
         

        Customer persistedCust = custSer.updateCustomer("108", Customer);
         

 assertEquals("108", persistedCust.getUserId());

        assertEquals("Surbhi", persistedCust.getName());

        assertEquals("surbhi8768@gmail.com", persistedCust.getEmail());
assertEquals("7007542271", persistedCust.getContactNo());
assertEquals(LocalDate.parse("1999/02/12"), persistedCust.getDob());

    }      
    @Test

    void testDeleteCustomer() throws ICustomerServiceException {

        Customer Customer = new Customer("108", "Surbhi", "surbhi8768@gmail.com","7007542271",LocalDate.parse("1999/02/12"));
         

           custSer.removeCustomer("108");

        Customer persistedCust = custSer.removeCustomer("108");
assertEquals("7007542271", persistedCust.getContactNo());
assertEquals(LocalDate.parse("1999/02/12"), persistedCust.getDob());
}  }