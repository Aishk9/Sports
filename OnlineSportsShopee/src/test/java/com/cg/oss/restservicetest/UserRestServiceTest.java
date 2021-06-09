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

import com.cg.oss.bean.User;
import com.cg.oss.OnlineSportsShopeeApplication;



//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserRestServiceTest {
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
    public void testFindUserByUserId() {
       HttpHeaders headers = new HttpHeaders();	//Represents an HTTP request or response entity, consisting of headers and body.
       HttpEntity<String> entity = new HttpEntity<String>(null, headers);
       ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/user/all",
       HttpMethod.GET, entity, String.class);  
       assertNotNull(response.getBody());
   }

   @Test
   public void testGetAllUsers() {
       User user = restTemplate.getForObject(getRootUrl() + "/user/101", User.class);
       System.out.println("User Id : "+user.getUsername());
       assertNotNull(user);
   }

   @Test
   public void testchangeUserPassword() {
       int id = 101;
       User user = restTemplate.getForObject(getRootUrl() + "/user/" + id,User.class);
       user.setPassword("67890");
       user.setFirstname("Himani");
       user.setLastname("kum");
       restTemplate.put(getRootUrl() + "/user/change/" + id, user);
       User changeUser = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
      assertNotNull(changeUser);

   }

   @Test
   public void testDeleteUserByUserId() {
        int id = 101;
        User user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);

        restTemplate.delete(getRootUrl() + "/user/delete/" + id);
        try {
             user = restTemplate.getForObject(getRootUrl() + "/user/" + id, User.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
   }
}