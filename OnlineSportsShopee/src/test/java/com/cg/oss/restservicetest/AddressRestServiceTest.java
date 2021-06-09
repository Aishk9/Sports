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
import com.cg.oss.bean.Address;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = OnlineSportsShopeeApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AddressRestServiceTest {
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
public void testGetAllAddressDetails() {
HttpHeaders headers = new HttpHeaders(); //Represents an HTTP request or response entity, consisting of headers and body.
HttpEntity<String> entity = new HttpEntity<String>(null, headers);
ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/Address/all",
HttpMethod.GET, entity, String.class);
assertNotNull(response.getBody());
}

 @Test
public void getAddressDetails() {
Address Address = restTemplate.getForObject(getRootUrl() + "/Address/321", Address.class);
System.out.println("Door No : "+Address.getDoorNo());
assertNotNull(Address);
}

 @Test
public void testUpdateAddress() {
String doorNo= "321";
Address Address = restTemplate.getForObject(getRootUrl() + "/Address/" + doorNo, Address.class);
Address.setStreet("Cross Road");
Address.setArea("Murugeshpallya");
restTemplate.put(getRootUrl() + "/Address/update/" + doorNo, Address);
Address updatedAddress = restTemplate.getForObject(getRootUrl() + "/Address/" + doorNo, Address.class);
assertNotNull(updatedAddress);

}

 @Test
public void testDeleteAddress() {
String doorNo ="321" ;
Address Address = restTemplate.getForObject(getRootUrl() + "/Address/" + doorNo, Address.class);
// assertNotNull(employee);
restTemplate.delete(getRootUrl() + "/Address/delete/" + doorNo);
try {
Address = restTemplate.getForObject(getRootUrl() + "/Address/" + doorNo, Address.class);
} catch (final HttpClientErrorException e) {
assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
}
}
}
