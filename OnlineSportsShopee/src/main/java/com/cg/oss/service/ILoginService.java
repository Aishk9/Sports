package com.cg.oss.service;

import com.cg.oss.bean.Login;
import com.cg.oss.serviceexception.ILoginServiceException;
public interface ILoginService {
    
    String signin(Login user);

    String signout(String userId) throws ILoginServiceException;

 

}
