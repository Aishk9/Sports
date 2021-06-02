package com.cg.oss.bean;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="CustomerNew")
public class Customer
{
@Id
private String userId;
private String name;
private String email;
private String contactNo;
private LocalDate dob;
@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="address1")
private Address address;

 public Customer(String userId, String name, String email, String contactNo, LocalDate dob) {
super();
this.userId = userId;
this.name = name;
this.email = email;
this.contactNo = contactNo;
this.dob = dob;

}
public Customer() {
super();
// TODO Auto-generated constructor stub
}

 public String getUserId() {
return userId;
}
public void setUserId(String userId) {
this.userId = userId;
}
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}
public String getEmail() {
return email;
}
public void setEmail(String email) {
this.email = email;
}
public String getContactNo() {
return contactNo;
}
public void setContactNo(String contactNo) {
this.contactNo = contactNo;
}
public LocalDate getDob() {
return dob;
}
public void setDob(LocalDate dob) {
this.dob = dob;
}
public Address getAddress() {
return address;
}
public void setAddress(Address address) {
this.address = address;
}
@Override
public String toString() {
return "Customer [userId=" + userId + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo
+ ", dob=" + dob + " ,address=\" + address + \" ]";
}

}