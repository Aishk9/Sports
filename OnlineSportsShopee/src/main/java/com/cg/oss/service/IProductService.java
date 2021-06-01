package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Product;
import com.cg.oss.serviceexception.IProductServiceException;

 

public interface IProductService {

 

    public List<Product> getAllProduct();
    
    public Product addProduct(Product product);
    
    public Product getProduct(long id) throws IProductServiceException;
    
    public Product removeProduct(long id) throws IProductServiceException;
    
    public Product updateProduct(long id, Product product) throws IProductServiceException;
    
    public List<Product> getProductsByName(String name) throws IProductServiceException;
    
    public List<Product> getProductsBySize(String size) throws IProductServiceException;
    
    public List<Product> getProductsByPrice(double price) throws IProductServiceException;
    
    public List<Product> getProductsByColor(String color) throws IProductServiceException;
}
 
