package com.cg.oss.bean;

import java.time.LocalDate;

 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

 

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

 

@Component
@Entity
@Table(name="Orders")
public class Order {
    @Id
    private long orderId;
    @Min(value=50,message="Amount must be equal or greater then 50")
    private double amount;
    private LocalDate billingDate;
    @NotEmpty(message = "Customer name is required")
    private String customer;
    @NotEmpty(message = "Payment methos is required")
    private String paymentMethod;
    /*@ManyToOne
    @JoinColumn(name="customer")
    private Customer customer;
    */
    
    public Order() {
        super();
    }
    
    public Order(long orderId, double amount, LocalDate billingDate, String customer, String paymentMethod) {
        super();
        this.orderId = orderId;
        this.amount = amount;
        this.billingDate = billingDate;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
    }
    
    public long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public LocalDate getBillingDate() {
        return billingDate;
    }
    
    public void setBillingDate(LocalDate billingDate) {
        this.billingDate = billingDate;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public void setCustomer(String customer) {
        this.customer = customer;
    }
    
    public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", customer="
                + customer + ", paymentMethod=" + paymentMethod + "]";
    }
}