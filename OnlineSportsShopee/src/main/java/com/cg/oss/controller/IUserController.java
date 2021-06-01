package com.cg.oss.controller;

import java.util.List;

 

import javax.validation.Valid;

 

import org.springframework.beans.factory.annotation.Autowired;

 

import org.springframework.web.bind.annotation.DeleteMapping;

 

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 


import com.cg.oss.bean.User;
import com.cg.oss.service.IUserService;
import com.cg.oss.serviceexception.IUserServiceException;


 


@RestController
public class IUserController {
    @Autowired
    IUserService regservice;
//READ
    
    @GetMapping("/user/userid/{userid}")
    public User findUserByUserId(@PathVariable String userid) throws IUserServiceException{
        if (regservice.findUserByUserId(userid) == null) {
            return null;
        }
        return regservice.findUserByUserId(userid);
    }

 

    @GetMapping("/user/findallusers")
    public List<User> findAllusers() {
        return regservice.getAllUsers();

 

    }
//WRITE
    
    @PostMapping("/user/save")
    public User save(@Valid @RequestBody User user){
        return regservice.createUser(user);
    }

 


//UPDATE
    
    @PutMapping("/user/{userid}/update")
    public User changeUserPassword(@Valid @RequestBody User user) throws IUserServiceException{
        return regservice.changeUserPassword(user);
    }
//DELETE
    
    @DeleteMapping("/user/{userid}")
    public User deleteUserByUserId(@PathVariable String userid) throws IUserServiceException{
        if(regservice.findUserByUserId(userid)==null){
          return null;
        }
        return regservice.deleteUserByUserId(userid);
        
    }
    
}
    
 










