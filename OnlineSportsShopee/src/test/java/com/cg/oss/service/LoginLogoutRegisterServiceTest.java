package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertThrows; 
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Login;
import com.cg.oss.dao.ILoginRepository;


@SpringBootTest
class LoginLogoutRegisterServiceTest {


    @Autowired
    ILoginService loginService;
    
     
    @Autowired
    ILoginRepository loginRepo;

 
    //validate login with valid userId and password
    @Test
    void testValidateLoginWithValidUserIdAndPassword() { 
        Login user = new Login();
        user.setUserId("admin");
        user.setPassword("admin@1234");
        loginService.signin(user);
        Login dbUsr = loginRepo.findById(user.getUserId()).get();
        assertEquals(user.getUserId(), dbUsr.getUserId());
        assertEquals(user.getPassword(), dbUsr.getPassword()); 
    }
    //validate login with invalid userId and password
    @Test
    void testValidateLoginWithInvalidUserIdAndPassword() throws Throwable {
        Login user = new Login();
        user.setUserId("riya");
        user.setPassword("min@1234");
        assertThrows(Exception.class, new Executable() {
         
        @Override
        public void execute() throws Throwable {
            loginService.signin(user);
        }
    });
    }
    //validate login with valid userId and invalid password 
    @Test
    void testValidateLoginWithValidUserIdAndInvalidPassword()  {
        Login user = new Login();
        user.setUserId("admin");
        user.setPassword("riya@342");
        assertThrows(Exception.class, new Executable() {
        @Override
        public void execute() throws Throwable {
            loginService.signin(user);
        }
    });
    }
    //validate login with invalid userId and valid password
    @Test
    void testValidateLoginWithInvalidUserIdAndValidPassword()  {
        Login user = new Login();
        user.setUserId("mini");
        user.setPassword("admin@1234");
        assertThrows(Exception.class, new Executable() {
        @Override
        public void execute() throws Throwable {
            loginService.signin(user);
        }
    
     
    });
    }
    //validate login with valid userId and without password
    @Test
    void testValidateLoginWithValidUserIdAndWithoutPassword() {
        Login user = new Login();
        user.setUserId("admin");
        assertThrows(Exception.class, new Executable() {
        @Override
        public void execute() throws Throwable {
            loginService.signin(user);
        }
    });
    }
}










