package com.cg.oss.restservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.oss.OnlineSportsShopeeApplication;
import com.cg.oss.bean.Customer;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerRestServiceTest {
@Autowired
private TestRestTemplate restTemplate;

 @LocalServerPort
private int port;

 private String getRootUrl() {
return "http://localhost:" + port;
}

 @Test
public void contextLoads() {

 }



 @Test
public void testGetAllCustomers() {
HttpHeaders headers = new HttpHeaders(); //Represents an HTTP request or response entity, consisting of headers and body.
HttpEntity<String> entity = new HttpEntity<String>(null, headers);
ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/customer/all",
HttpMethod.GET, entity, String.class);
assertNotNull(response.getBody());
}

 @Test
public void testGetCustomerById() {
Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/115", Customer.class);
System.out.println("Customer Id : "+customer.getUserId());
assertNotNull(customer);
}

 @Test
public void testUpdateCustomer() {
String id = "115";
Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
customer.setName("Ayush Das");
customer.setEmail("dasayu@rediff.com");
customer.setContactNo("8763798706");
restTemplate.put(getRootUrl() + "/customer/update/" + id, customer);
Customer updatedCustomer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
assertNotNull(updatedCustomer);

}

 @Test
public void testRemovePayment() {
int id = 115;
Customer customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
// assertNotNull(employee);
restTemplate.delete(getRootUrl() + "/customer/remove/" + id);
try {
customer = restTemplate.getForObject(getRootUrl() + "/customer/" + id, Customer.class);
} catch (final HttpClientErrorException e) {
assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
}
}
}
