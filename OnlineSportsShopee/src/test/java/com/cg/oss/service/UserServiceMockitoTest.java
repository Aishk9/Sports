package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

 

import com.cg.oss.bean.User;
import com.cg.oss.dao.IUserRepository;
import com.cg.oss.serviceexception.IUserServiceException;
import com.cg.oss.serviceimpl.IUserServiceImpl;

 


@ExtendWith(SpringExtension.class)
public class UserServiceMockitoTest {
    @InjectMocks
    IUserServiceImpl regservice;
    @MockBean
    IUserRepository regRepo;

 

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

 

    @Test

 

    void findUserByUserId() throws IUserServiceException  {
        User user = new User();
        user.setUsername("apple");
        user.setFirstname("firstname");
        user.setLastname("Lastname");
        user.setPassword("M0n1");
        Mockito.when(regRepo.findById("apple")).thenReturn(Optional.of(user));
        User user1 = regservice.findUserByUserId("apple");
        assertEquals(user.toString(), user1.toString());

 

    }

 

    @Test

 

    void findAllUsers(){
        User user = new User();
        user.setUsername("apple");
        user.setFirstname("firstname");
        user.setLastname("Lastname");
        user.setPassword("M0n1");
        List<User> userlist = new ArrayList<>();
        userlist.add(user);
        Mockito.when(regRepo.findAll()).thenReturn(userlist);
        List<User> userlist1 = regservice.getAllUsers();
        assertEquals(userlist1.size(), userlist.size());

 

    }

 

    @Test

 

    void updateUser() throws IUserServiceException  {
        User user = new User();
        user.setUsername("apple");
        user.setFirstname("firstname");
        user.setLastname("Lastname");
        user.setPassword("M0n1");
      /*  Mockito.when(regservice.findUserByUserId("useridd")).thenReturn(Optional.of(user));
        Mockito.when(regRepo.save(user)).thenReturn(user);
        User temp = regservice.changeUserPassword(user);
        assertEquals(user.toString(), temp.toString());*/
    }

 

    @Test

 

    void deleteUserByUserId() throws IUserServiceException {
        User user = new User();
        user.setUsername("apple");
        user.setFirstname("firstname");
        user.setLastname("Lastname");
        user.setPassword("M0n1");
        Mockito.when(regRepo.findById("useridd")).thenReturn(Optional.of(user));
        User temp = regservice.deleteUserByUserId("useridd");
        assertEquals(user.toString(), temp.toString());

 

    }

 

}




















