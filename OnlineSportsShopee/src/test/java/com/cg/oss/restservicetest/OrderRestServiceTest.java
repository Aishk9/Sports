package com.cg.oss.restservicetest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

 

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

 

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
import com.cg.oss.bean.Order;

 

@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderRestServiceTest 
{
     @Autowired
     private TestRestTemplate restTemplate;

 

     @LocalServerPort
     private int port;

 

     DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

 

     LocalDate date = LocalDate.parse("11/07/1999", format);
     
     private String getRootUrl() {
         return "http://localhost:" + port;
     }

 

     @Test
     public void contextLoads() {

 

     }

 

  
 

     @Test
     public void testGetAllOrder() {
        HttpHeaders headers = new HttpHeaders();    //Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/order/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

 

    @Test
    public void testGetOrderById() {
        Order order = restTemplate.getForObject(getRootUrl() + "/order/byId/101", Order.class);
        System.out.println("Order Amount : "+order.getAmount());
        assertNotNull(order);
    }

 

    @Test
    public void testUpdateOrder() {
        int id = 101;
        Order order = restTemplate.getForObject(getRootUrl() + "/order/byId/" + id, Order.class);
        order.setOrderId(102);
        order.setAmount(2500);
        order.setBillingDate(date);
        order.setCustomer("Smith");
        order.setPaymentMethod("Credit card");
        restTemplate.put(getRootUrl() + "/order/update/" + id, order);
        Order updatedOrder = restTemplate.getForObject(getRootUrl() + "/order/byId/" + id, Order.class);
        assertNotNull(updatedOrder);
        //assertEquals(order.getAmount(), updatedOrder.getAmount());
    }

 

    @Test
    public void testDeleteOrder() {
         int id = 101;
         Order order = restTemplate.getForObject(getRootUrl() + "/order/byId/" + id, Order.class);
         //assertNotNull(order);
         restTemplate.delete(getRootUrl() + "/employees/deleteEmployee/" + id);
         try {
              order = restTemplate.getForObject(getRootUrl() + "/order/byId/" + id, Order.class);
         } 
         catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
 