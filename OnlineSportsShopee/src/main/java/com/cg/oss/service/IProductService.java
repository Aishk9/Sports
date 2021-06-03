package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Product;
import com.cg.oss.exception.ResourceNotFoundException;


 

public interface IProductService {

 

    public List<Product> getAllProduct();
    
    public Product addProduct(Product product);
    
    public Product getProduct(long id) throws ResourceNotFoundException;
    
    public Product removeProduct(long id) throws ResourceNotFoundException;
    
    public Product updateProduct(long id, Product product) throws ResourceNotFoundException;
    
    public List<Product> getProductsByName(String name) throws ResourceNotFoundException;
    
    public List<Product> getProductsBySize(String size) throws ResourceNotFoundException;
    
    public List<Product> getProductsByPrice(double price) throws ResourceNotFoundException;
    
    public List<Product> getProductsByColor(String color) throws ResourceNotFoundException;
}
 
