package com.cg.oss.bean;

import java.time.LocalDate;

 

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

 

import org.springframework.stereotype.Component;

 

@Component
@Entity
@Table(name = "productTable")
public class Product {
    @Id
    private long productId;
    @NotEmpty(message = "Project name is required")
    private String productName;
    private String category;
    private String description;
    @NotEmpty(message = "Brand is required")
    private String brand; 
    private String color;
    private String productSize;
    private double mrp;
    private int discount;
    private double priceAfterDiscount;
    private boolean inStock;
    private LocalDate estimatedDelivery;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cart")
    private Cart cart;
    public Product() {
        
    }
    public Product(long productId, String productName, String category, String description, String brand, String color,
            String productSize, double mrp, int discount, double priceAfterDiscount,boolean inStock,
            LocalDate estimatedDelivery) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.productSize = productSize;
        this.mrp = mrp;
        this.discount = discount;
        this.priceAfterDiscount = priceAfterDiscount;
        this.inStock = inStock;
        this.estimatedDelivery = estimatedDelivery;
    }
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getProductSize() {
        return productSize;
    }
    public void setSize_Var(String productSize) {
        this.productSize = productSize;
    }
    public double getMrp() {
        return mrp;
    }
    public void setMrp(double mrp) {
        this.mrp = mrp;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }
    public void setPriceAfterDiscount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }
    public boolean isInStock() {
        return inStock;
    }
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
    public LocalDate getEstimatedDelivery() {
        return estimatedDelivery;
    }
    public void setEstimatedDelivery(LocalDate estimatedDelivery) {
        this.estimatedDelivery = estimatedDelivery;
    }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
                + ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + productSize + ", mrp="
                + mrp + ", discount=" + discount + ", priceAfterDiscount=" + priceAfterDiscount 
                + ", estimatedDelivery=" + estimatedDelivery + "]";
    }
    
}
 