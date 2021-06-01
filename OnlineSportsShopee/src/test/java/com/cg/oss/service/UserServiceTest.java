package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;



import java.util.List;

 


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oss.bean.User;
import com.cg.oss.dao.IUserRepository;
import com.cg.oss.serviceexception.IUserServiceException;



 


@SpringBootTest
public class UserServiceTest {

 

    @Autowired
    IUserService regservice;
    @Autowired
    IUserRepository regRepo;

 

    static User getMockUser() {
        User user = new User();
        user.setUsername("userid");
        user.setFirstname("firstname");
        user.setLastname("Lastname");
        user.setPassword("M0n1sha04");
        return user;
    }

 

//Test READ
    @Test
    void findUserByUserId() throws IUserServiceException{
        User user = getMockUser();
        regservice.createUser(user);
        User temp = regservice.findUserByUserId("userid");
        assertEquals(user.toString(), temp.toString());

 

    }

 

//Test READ
    @Test
    void findAllUsers() {
        List<User> userlist = regservice.getAllUsers();
        User user = getMockUser();
        regservice.createUser(user);
        List<User> userlist1 = regservice.getAllUsers();
        assertEquals(userlist1.size(), userlist.size());
    }

 

//Test UPDATE
    @Test
    void updateUser() throws IUserServiceException {
        User user = new User();
        user.setUsername("Monisha");
        user.setFirstname("Monisha");
        user.setLastname("sekar");
        user.setPassword("M0n1sha07");
        regservice.createUser(user);
        User temp = regservice.changeUserPassword(user);
        assertEquals(user.toString(), temp.toString());
    }

 

//Test DELETE
    @Test
    void deleteUserByUserId() throws IUserServiceException  {
        User user = new User();
        user.setUsername("Monisha");
        user.setFirstname("Monisha");
        user.setLastname("sekar");
        user.setPassword("M0n1sha07");
        regservice.createUser(user);
        User temp = regservice.deleteUserByUserId("Monisha");
        assertEquals(user.toString(), temp.toString());
    }

 

}
 