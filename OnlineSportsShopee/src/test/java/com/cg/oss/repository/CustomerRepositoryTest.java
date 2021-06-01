package com.cg.oss.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.oss.bean.Customer;
import com.cg.oss.bean.Product;
import com.cg.oss.dao.ICustomerRepository;
import com.cg.oss.dao.IProductRepository;
public class CustomerRepositoryTest {
@Autowired
ICustomerRepository custRepo;

 @Test
void testCreateCustomer() {

 Customer customer = new Customer("105", "Abhinabh", "abhinabh46@gmail.com","7008976321",LocalDate.parse("1996/04/11"));

 Customer persistedCust = custRepo.save(customer);

 assertEquals("105", persistedCust.getUserId());

        assertEquals("Abhinabh", persistedCust.getName());

        assertEquals("abhinabh46@gmail.com", persistedCust.getEmail());
assertEquals("7008976321", persistedCust.getContactNo());
assertEquals(LocalDate.parse("1996/04/11"), persistedCust.getDob());

}
}