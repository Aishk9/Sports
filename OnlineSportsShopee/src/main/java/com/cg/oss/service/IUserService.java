package com.cg.oss.service;

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.User;
import com.cg.oss.exception.ResourceNotFoundException;


 

@Service
public interface IUserService {
    public User findUserByUserId(String userid) throws ResourceNotFoundException ;

 

    public List<User> getAllUsers();

 

    public User createUser(User user);

 

    public User changeUserPassword(User user) throws ResourceNotFoundException;

 

    public User deleteUserByUserId(String userid) throws ResourceNotFoundException;

 

}










