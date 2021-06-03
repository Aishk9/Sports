package com.cg.oss.bean;

import javax.persistence.Entity;

 

 

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

 

import org.springframework.stereotype.Component;

 

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 

 
@Component
@Entity
@Table(name="LoginNew")

 

 


public class Login {

 

    @Override
    public String toString() {
        return "Login [id=" + id + ", userId=" + userId + ", password=" + password + ", isLoggedIn=" + isLoggedIn + "]";
    }
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Login(int id, @NotEmpty(message = "Please enter your userid") String userId,
            @NotEmpty(message = "Please enter your password") String password, boolean isLoggedIn) {
        super();
        this.id = id;
        this.userId = userId;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }
    @GeneratedValue
    private int id;
    @Id
    @NotEmpty(message="Please enter your userid")
    private String userId;
    @NotEmpty(message="Please enter your password")
    private String password;
    private boolean isLoggedIn = false;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }
    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }
    
}