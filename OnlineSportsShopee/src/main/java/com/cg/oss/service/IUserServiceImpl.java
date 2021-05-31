package com.cg.oss.service;

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 


import com.cg.oss.bean.User;
import com.cg.oss.dao.IUserRepository;

 

@Service
public class IUserServiceImpl implements IUserService {

 

    @Autowired
    IUserRepository regRepo;

 

    @Override
    public User createUser(User user){
        return regRepo.save(user);

 

    }

 

    @Override
    public User findUserByUserId(String userid) throws IUserServiceException {
        Optional<User> optional = regRepo.findById(userid);
        if (!optional.isPresent()) {
            throw new IUserServiceException();
        }

        return optional.get();
    }

 

    @Override
    public List<User> getAllUsers() {
        return regRepo.findAll();
    }

 

    @Override
    public User changeUserPassword(User user) throws IUserServiceException {
        User dbUser = getUser(user);
        Optional<User> use = regRepo.findById(dbUser.getUsername());
        if(!use.isPresent()) {
        	throw new IUserServiceException();
        }
        if (isNullOrEmpty(dbUser.getPassword())) {
            dbUser.setPassword(user.getPassword());
        }
        
        
        return regRepo.save(dbUser);
    }

 

    private boolean isNullOrEmpty(String value) {
        return value != null && !value.equals("");
    }

 

    private User getUser(User user) {
        Optional<User> userfield = regRepo.findById(user.getUsername());
        User dbUser=null;
        if (userfield.isPresent()) {
            dbUser = userfield.get();
        }
        return dbUser;
    }

 

    @Override
    public User deleteUserByUserId(String userid) throws IUserServiceException{
        Optional<User> optional = regRepo.findById(userid);
        if (!optional.isPresent()) {
            throw new IUserServiceException();
        }
        regRepo.deleteById(userid);
        return optional.get();
    }
}














