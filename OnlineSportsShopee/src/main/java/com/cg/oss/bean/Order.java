package com.cg.oss.bean;

import java.time.LocalDate;

 

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
 
    @NotEmpty(message = "Payment methos is required")
    private String paymentMethod;
    @ManyToOne
    @JoinColumn(name="userId")
    private Customer customer;
   @OneToMany
   @JoinColumn(name="productId")
   private Product product;
   
   @OneToOne
   @JoinColumn(name="paymentId")
   private Payment payment;
    
    public Order() {
        super();
    }
    
    public Order(long orderId, double amount, LocalDate billingDate, Customer customer, String paymentMethod, Product product, Payment Payment) {
        super();
        this.orderId = orderId;
        this.amount = amount;
        this.billingDate = billingDate;
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        this.product=product;
        this.payment=payment;
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
    
    public Customer getCustomer() {
        return customer;
    }
    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public String getPaymentMethod() {
        return paymentMethod;
    }
    
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", amount=" + amount + ", billingDate=" + billingDate + ", paymentMethod="
				+ paymentMethod + ", customer=" + customer + ", product=" + product + ", payment=" + payment
				+ ", getOrderId()=" + getOrderId() + ", getAmount()=" + getAmount() + ", getBillingDate()="
				+ getBillingDate() + ", getCustomer()=" + getCustomer() + ", getProduct()=" + getProduct()
				+ ", getPayment()=" + getPayment() + ", getPaymentMethod()=" + getPaymentMethod() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}