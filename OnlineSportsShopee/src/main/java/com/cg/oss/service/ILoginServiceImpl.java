package com.cg.oss.service;



import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.Login;
import com.cg.oss.dao.ILoginRepository;

 

@Service
public class ILoginServiceImpl implements ILoginService {

 

    @Autowired
    ILoginRepository loginRepo;
    

 


    @Override
    public String signin(Login user){
        Optional<Login> dbUsr = loginRepo.findById(user.getUserId());
        String message = null;
        if (!dbUsr.isPresent() || !dbUsr.get().isLoggedIn()) {
            user.setLoggedIn(true);
            loginRepo.save(user);
            message = "Succesfully signed in " + user.getUserId();
        } else {
            message = "Already signed in " + user.getUserId();
        }

 

        return message;
    }

 

    @Override
    public String signout(String userId) throws ILoginServiceException {
        Optional<Login> userfield = loginRepo.findById(userId);
        Login dbUsr = null;
        if (userfield.isPresent()) {
            dbUsr = userfield.get();
        }
        if (dbUsr != null && dbUsr.getUserId().equals(userId) && dbUsr.isLoggedIn()) {

 

            dbUsr.setLoggedIn(false);
            loginRepo.save(dbUsr);
            return "signout successfully";
        }
        throw new ILoginServiceException();
    }
    
    
}
 










