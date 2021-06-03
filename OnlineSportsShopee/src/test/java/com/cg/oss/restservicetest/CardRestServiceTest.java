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
import com.cg.oss.bean.Card;




//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CardRestServiceTest {
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
     public void testGetAllCards() {
        HttpHeaders headers = new HttpHeaders();	//Represents an HTTP request or response entity, consisting of headers and body.
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/Card/all",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetCardById() {
        Card Card = restTemplate.getForObject(getRootUrl() + "/Card/123456", Card.class);
        System.out.println("Card Number : "+Card.getCardNumber());
        assertNotNull(Card);
    }

    @Test
    public void testUpdateCard() {
        int id= 123456;
        Card Card = restTemplate.getForObject(getRootUrl() + "/Card/" + id, Card.class);
        Card.setCardName("Marco K");
        Card.setCardNumber(123456);
        Card.setCardExpiry(date);
        Card.setCvv(999);
        restTemplate.put(getRootUrl() + "/Card/update/" + id, Card);
        Card updatedCard = restTemplate.getForObject(getRootUrl() + "/Card/" + id, Card.class);
       assertNotNull(updatedCard);
	//assertEquals(Card.getCardName(), updatedCard.getCardName());
    }

    @Test
    public void testDeleteCard() {
         int id = 123456;
         Card Card = restTemplate.getForObject(getRootUrl() + "/Card/" + id, Card.class);
//         assertNotNull(employee);
         restTemplate.delete(getRootUrl() + "/Card/delete/" + id);
         try {
              Card = restTemplate.getForObject(getRootUrl() + "/Card/" + id, Card.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}
