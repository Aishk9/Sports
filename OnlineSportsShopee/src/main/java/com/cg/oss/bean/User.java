package com.cg.oss.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

 

import org.springframework.stereotype.Component;

 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Entity
@Table(name="UserNew")
public class User {
  //Userid Validation
    @OneToOne
    @JoinColumn(name = "userId")
    private Login login;
    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
                + lastname + "]";
    }

    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

 

 

    public User(
            @NotEmpty(message = "Please Enter your UserId") @Pattern(regexp = "[A-Za-z]+", message = "UserId is Invalid") @Size(min = 4, message = "Userid is should have atleast 4 character ") String username,
            @NotEmpty(message = "Please Enter your Password") @Pattern(regexp = "[A-Za-z0-9]+", message = "Password is Invalid") @Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters") String password,
            @NotEmpty(message = "Please Enter your FirstName") @Pattern(regexp = "[A-Za-z]+", message = "FirstName is Invalid") @Size(min = 2, max = 10, message = "Firstname should have atleast 7 characters not less than 10 characters") String firstname,
            @NotEmpty(message = "Please Enter your LastName") @Pattern(regexp = "[A-Za-z]+", message = "LastName is Invalid") @Size(min = 1, max = 10, message = "Lastnmae should have atleast 7 characters not less than 10 characters") String lastname) {
        super();
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
    }

 

 

    @Id
    @NotEmpty(message="Please Enter your UserId")
    @Pattern(regexp = "[A-Za-z]+",message="UserId is Invalid")
    @Size(min = 4, message = "Userid is should have atleast 4 character ")
    private String username;
    
    //Password Validation
    @NotEmpty(message="Please Enter your Password")
    @Pattern(regexp = "[A-Za-z0-9]+",message="Password is Invalid")
    @Size(min = 8, max = 15, message = "Password should have atleast 8 characters not less than 15 characters")
    private String password;
    
    //FirstNmae Validation
    @NotEmpty(message="Please Enter your FirstName")
    @Pattern(regexp = "[A-Za-z]+",message="FirstName is Invalid")
    @Size(min = 2, max = 10, message = "Firstname should have atleast 7 characters not less than 10 characters")
    private String firstname;
    
    //LastName Validation
    @NotEmpty(message="Please Enter your LastName")
    @Pattern(regexp = "[A-Za-z]+",message="LastName is Invalid")
    @Size(min = 1, max = 10, message = "Lastnmae should have atleast 7 characters not less than 10 characters")
    private String lastname;

 public String getUsername() {
        return username;
    }
  public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

 public void setPassword(String password) {
        this.password = password;
    }

 public String getFirstname() {
        return firstname;
    }

 public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

  public String getLastname() {
        return lastname;
    }

 public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    

 

 

 

}