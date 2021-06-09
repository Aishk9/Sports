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
import com.cg.oss.bean.Product;

 


//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRestServiceTest {
     @Autowired
     private TestRestTemplate restTemplate;

 

     @LocalServerPort
     private int port;

 

     private String getRootUrl() {
         return "http://localhost:" + port;
     }
     
     DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

 

     LocalDate date = LocalDate.parse("11/07/1999", format);

 

     @Test
     public void contextLoads() {

 

     }
     

 

 
     @Test
     public void testGetAllProducts() {
        HttpHeaders headers = new HttpHeaders();    //Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/product/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

 

    @Test
    public void testGetProductById() {
        Product product = restTemplate.getForObject(getRootUrl() + "/product/101", Product.class);
        System.out.println("Emp Name : "+product.getProductName());
        assertNotNull(product);
    }
    
    @Test
    public void testGetProductByPrice() {
        Product product = restTemplate.getForObject(getRootUrl() + "/product/price/2000", Product.class);
        System.out.println("Emp Name : "+product.getProductName());
        assertNotNull(product);
    }
    
    @Test
    public void testGetProductByColor() {
        Product product = restTemplate.getForObject(getRootUrl() + "/product/color/white", Product.class);
        System.out.println("Emp Name : "+product.getProductName());
        assertNotNull(product);
    }
    
    @Test
    public void testGetProductByName() {
        Product product = restTemplate.getForObject(getRootUrl() + "/product/name/ball", Product.class);
        System.out.println("Emp Name : "+product.getProductName());
        assertNotNull(product);
    }
    

 

    @Test
    public void testUpdateProduct() {
        int id = 11;
        Product product = restTemplate.getForObject(getRootUrl() + "/product/update/" + id, Product.class);
        product.setProductName("cricketBall");
        product.setMrp(1000);
        restTemplate.put(getRootUrl() + "/product/updateProduct/" + id, product);
        Product updateProduct = restTemplate.getForObject(getRootUrl() + "/product/byId/" + id, Product.class);      
        assertNotNull(updateProduct);
  
    }

 

    @Test
    public void testDeleteEmployee() {
         int id = 16;
         Product product = restTemplate.getForObject(getRootUrl() + "/product/byId/" + id, Product.class);
         restTemplate.delete(getRootUrl() + "/proc/deleteProduct/" + id);
         try {
              product = restTemplate.getForObject(getRootUrl() + "/product/byId/" + id, Product.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}