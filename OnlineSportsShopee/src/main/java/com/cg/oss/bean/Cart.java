package com.cg.oss.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

 

import org.springframework.stereotype.Component;

 

@Entity
public class Cart {
     @Id
     private long cartId;
     private String imageName;

 

     @NotEmpty(message = "productName is required")
     private String productName;
     private int quantity;
     private double price;
     private double total;
     public Cart() {
         
     }
     
    public Cart(long cartId, String imageName, String productName, int quantity, double price, double total) {
        super();
        this.cartId = cartId;
        this.imageName = imageName;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
    }

 

    public long getCartId() {
        return cartId;
    }
    public void setCartId(long cartId) {
        this.cartId = cartId;
    }
    public String getImageName() {
        return imageName;
    }
    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }

 

    @Override
    public String toString() {
        return "Cart [cartId=" + cartId + ", imageName=" + imageName + ", productName=" + productName + ", quantity="
                + quantity + ", price=" + price + ", total=" + total + "]";
    }
    
}