package com.cg.oss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Login;
import com.cg.oss.bean.User;
import com.cg.oss.service.ILoginService;

import com.cg.oss.service.IUserService;
import com.cg.oss.serviceexception.ILoginServiceException;
import com.cg.oss.serviceexception.IUserServiceException;


 

@RestController
public class ILoginController {

 

    @Autowired
    ILoginService loginService;
    @Autowired
    IUserService userService;
    // login service
    @PostMapping("/signin")
    public String Login(@RequestBody Login login) throws IUserServiceException,ILoginServiceException {
        String message=null;
        User userfield = userService.findUserByUserId(login.getUserId()) ;
        if(userfield !=null && userfield.getPassword().equals(login.getPassword())) {
            message = loginService.signin(login);
        }
        return message;
    }
    //logout service
    @GetMapping("/signout/{userId}")
    public String Logout( @PathVariable("userId")String userId) throws ILoginServiceException{
        return loginService.signout(userId);
    }

 

}