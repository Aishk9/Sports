package com.cg.oss.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Product;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IProductService;
import com.cg.oss.serviceexception.IProductServiceException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Product;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IProductService;


 

@RestController
public class IProductController {

 

    @Autowired
    private IProductService product_service;

 

    @RequestMapping(value = "/product/all", method = RequestMethod.GET)
    public List<Product> getAllProducts() {
        return product_service.getAllProduct();
    }

 

    @RequestMapping(value = "/product/add", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product new_product) {
        return product_service.addProduct(new_product);
    }

 

    @RequestMapping(value = "/product/{product_id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable Long product_id) throws ResourceNotFoundException, IProductServiceException {
        try {
            Product product = product_service.getProduct(product_id);
            if (product == null) {
                throw new ResourceNotFoundException("Not Found");
            }
               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
               LocalDate now = LocalDate.now(); 
               product.setEstimatedDelivery(now.plusDays(5));
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/delete/{id}", method = RequestMethod.DELETE)
    public Product removeProduct(@PathVariable("id") int product_Id) throws ResourceNotFoundException, IProductServiceException {
        try {
            Product product = product_service.removeProduct(product_Id);
            if (product == null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/update/{id}", method = RequestMethod.PUT)
    public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) throws ResourceNotFoundException, IProductServiceException {

 

        try {
            Product product1 = product_service.updateProduct(id, product);
            if (product1 == null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product1;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/name/{name}", method = RequestMethod.GET)
    public List<Product> findByProductByName(@PathVariable("name") String name) throws ResourceNotFoundException, IProductServiceException{
        try {
            List<Product> product = product_service.getProductsByName(name);
            if (product.isEmpty()) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/size/{size}", method = RequestMethod.GET)
    public List<Product> findByProductBySize(@PathVariable("size") String size) throws ResourceNotFoundException, IProductServiceException{
        try {
            List<Product> product = product_service.getProductsBySize(size);
            if (product.isEmpty()) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/price/{price}", method = RequestMethod.GET)
    public List<Product> findByProductByPrice(@PathVariable("price") double price) throws ResourceNotFoundException, IProductServiceException{
        try {
            List<Product> product = product_service.getProductsByPrice(price);
            if (product.isEmpty()) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

    @RequestMapping(value = "/product/color/{color}", method = RequestMethod.GET)
    public List<Product> findByProductByColor(@PathVariable("color") String color) throws ResourceNotFoundException, IProductServiceException{
        try {
            List<Product> product = product_service.getProductsByColor(color);
            if (product.isEmpty()) {
                throw new ResourceNotFoundException("Not Found");
            }
            return product;
        } catch (IProductServiceException e) {
            throw new IProductServiceException("No Products Found");
        }
    }

 

}
 