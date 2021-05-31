package com.cg.oss.service;

import java.util.List;

 

import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.User;

 

@Service
public interface IUserService {
    public User findUserByUserId(String userid) throws IUserServiceException ;

 

    public List<User> getAllUsers();

 

    public User createUser(User user);

 

    public User changeUserPassword(User user) throws IUserServiceException;

 

    public User deleteUserByUserId(String userid) throws IUserServiceException;

 

}










