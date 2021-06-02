package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.oss.bean.Customer;
import com.cg.oss.dao.ICustomerRepository;
import com.cg.oss.serviceexception.ICustomerServiceException;
import com.cg.oss.serviceimpl.ICustomerServiceImpl;


@ExtendWith(SpringExtension.class)
class CustomerServiceMockitoTest {
// Mock - imitating
// DB -
// Product -
// @InjectMock - injects EmployeeService and inject dependent classes/interfaces
// that are annotated with @Mock
@InjectMocks
ICustomerServiceImpl custSer;
// @MockBean - injecting external services
@MockBean
ICustomerRepository custRepo;

DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

LocalDate date = LocalDate.parse("11/07/1999", format);

// Initialization of mock objects
@BeforeEach
void init() {
MockitoAnnotations.openMocks(this);
}
@Test
void testCreateCustomer() {
Customer customer = new Customer("101", "Sriya", "sriya29@gmail.com","8736547891",date);

 Mockito.when(custRepo.save(customer)).thenReturn(customer);

 Customer persistedCust = custSer.addCustomer(customer);
assertEquals("101", persistedCust.getUserId());

        assertEquals("Sriya", persistedCust.getName());

        assertEquals("sriya29@gmail.com", persistedCust.getEmail());
assertEquals("8736547891", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());

}

 @Test
void testCustomerById() throws ICustomerServiceException {
Customer customer = new Customer("102", "Shilpa", "shilpaa789@gmail.com","6789965262",date);

 Mockito.when(custRepo.findById("102")).thenReturn(Optional.of(customer));

 Customer persistedCust = custSer.getCustomer("102");

 assertEquals("102", persistedCust.getUserId());

        assertEquals("Shilpa", persistedCust.getName());

        assertEquals("shilpaa789@gmail.com", persistedCust.getEmail());
assertEquals("6789965262", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());

}

 @Test
void testAllCustomer() {
Customer customer1 = new Customer("102", "Shilpa", "shilpaa789@gmail.com","6789965262",date);

 Customer customer2 = new Customer("101", "Sriya", "sriya29@gmail.com","8736547891",date);

Customer customer3 = new Customer("103", "Ragini", "raginidas@gmail.com","8988776544",date);

List<Customer> customerList = new ArrayList<>();
customerList.add(customer1);
customerList.add(customer2);
customerList.add(customer3);

 Mockito.when(custRepo.findAll()).thenReturn(customerList);

 List<Customer> customers = custSer.getAllCustomers();

 assertEquals(3, customers.size());

 }

 @Test
void testUpdateCustomer() throws ICustomerServiceException {
Customer customer = new Customer("105", "Abhinabh", "abhinabh46@gmail.com","7008976321",date);

Mockito.when(custRepo.findById("105")).thenReturn(Optional.of(customer));
Mockito.when(custRepo.save(customer)).thenReturn(customer);

 Customer persistedCust = custSer.updateCustomer("105", customer);

 assertEquals("105", persistedCust.getUserId());

        assertEquals("Abhinabh", persistedCust.getName());

        assertEquals("abhinabh46@gmail.com", persistedCust.getEmail());
assertEquals("7008976321", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());

}

 @Test
void testDeleteCustomer() throws ICustomerServiceException {
Customer customer = new Customer("105", "Abhinabh", "abhinabh46@gmail.com","7008976321",date);

Mockito.when(custRepo.findById("105")).thenReturn(Optional.of(customer));
custRepo.deleteById("105");
Customer persistedCust = custSer.removeCustomer("105");

 assertEquals("105", persistedCust.getUserId());

        assertEquals("Abhinabh", persistedCust.getName());

        assertEquals("abhinabh46@gmail.com", persistedCust.getEmail());
assertEquals("7008976321", persistedCust.getContactNo());
assertEquals(date, persistedCust.getDob());

}
}
