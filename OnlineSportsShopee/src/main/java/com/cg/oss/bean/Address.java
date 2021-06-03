package com.cg.oss.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="Address1")
public class Address {

 @Id
private String doorNo;
@NotEmpty(message = "Street is required")
private String street;
@NotEmpty(message = "Area is required")
private String area;
@NotEmpty(message = "City is required")
private String city;
@NotEmpty(message = "State is required")
private String state;
@NotEmpty(message = "Pincode is required")
private int pincode;

 public Address() {
super();
// TODO Auto-generated constructor stub
}
public Address(String doorNo, String street, String area, String city, String state, int pincode) {
super();
this.doorNo = doorNo;
this.street = street;
this.area = area;
this.city = city;
this.state = state;
this.pincode = pincode;
}
public String getDoorNo() {
return doorNo;
}
public void setDoorNo(String doorNo) {
this.doorNo = doorNo;
}
public String getStreet() {
return street;
}
public void setStreet(String street) {
this.street = street;
}
public String getArea() {
return area;
}
public void setArea(String area) {
this.area = area;
}
public String getCity() {
return city;
}
public void setCity(String city) {
this.city = city;
}
public String getState() {
return state;
}
public void setState(String state) {
this.state = state;
}
public int getPincode() {
return pincode;
}
public void setPincode(int pincode) {
this.pincode = pincode;
}
@Override
public String toString() {
return "Address [doorNo=" + doorNo + ", street=" + street + ", area=" + area + ", city=" + city + ", state="
+ state + ", pincode=" + pincode + "]";
}

}