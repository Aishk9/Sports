package com.cg.oss.service;

import com.cg.oss.bean.Login;
public interface ILoginService {
    
    String signin(Login user);

    String signout(String userId) throws ILoginServiceException;

 

}
