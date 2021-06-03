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

import com.cg.oss.bean.Payment;
import com.cg.oss.OnlineSportsShopeeApplication;




//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentRestServiceTest {
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
     public void testGetAllPayments() {
        HttpHeaders headers = new HttpHeaders();	//Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/payment/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetPaymentById() {
        Payment payment = restTemplate.getForObject(getRootUrl() + "/payment/115", Payment.class);
        System.out.println("Payment Id : "+payment.getPaymentId());
        assertNotNull(payment);
    }

    @Test
    public void testUpdatePayment() {
        int id = 115;
        Payment payment = restTemplate.getForObject(getRootUrl() + "/payment/" + id, Payment.class);
        payment.setType("CreditCard");
        payment.setStatus("Pending");
        restTemplate.put(getRootUrl() + "/payment/update/" + id, payment);
        Payment updatedPayment = restTemplate.getForObject(getRootUrl() + "/payment/" + id, Payment.class);
       assertNotNull(updatedPayment);
//	assertEquals(payment.getType(), updatedPayment.getType());
    }

    @Test
    public void testDeletePayment() {
         int id = 115;
         Payment payment = restTemplate.getForObject(getRootUrl() + "/payment/" + id, Payment.class);
//         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/payment/delete/" + id);
         try {
              payment = restTemplate.getForObject(getRootUrl() + "/payment/" + id, Payment.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
