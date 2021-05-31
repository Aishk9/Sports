package com.cg.oss.service;

import java.util.List;



import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.Product;
import com.cg.oss.dao.IProductRepository;

 

@Service
public class IProductServiceImpl implements IProductService{

 

    @Autowired
    private IProductRepository product_Repo;
    @Override
    public Product addProduct(Product product) {
        return product_Repo.save(product);
    }
    @Override
    public List<Product> getAllProduct() {
        return product_Repo.findAll();
    }
    @Override
    public Product getProduct(long product_id) throws IProductServiceException{
        Optional<Product> product = product_Repo.findById(product_id);
            if(!product.isPresent()) {
                throw new IProductServiceException("No Exception");
            }
            
           return product.get();
    }
    @Override
    public Product removeProduct(long id) throws IProductServiceException {
         Optional<Product> product = product_Repo.findById(id);
            if(!product.isPresent()) {
                throw new IProductServiceException("No Exception");
            }
           product_Repo.delete(product.get());
           return product.get();
    }
    @Override
    public Product updateProduct(long id, Product product) throws IProductServiceException{
          Optional<Product> prod =  product_Repo.findById(id);
            if (!prod.isPresent()) {
                throw new IProductServiceException("No Exception");
            }
            else  {
                         product.setProductId(id);
                         return product_Repo.save(product);
            }
    }
    @Override
    public List<Product> getProductsByName(String productName) throws IProductServiceException{
        List<Product> product = product_Repo.findByProductName(productName);
        if(product.isEmpty()) {
            throw new IProductServiceException("No Exception");
        }
        else {
        return product;
        }
    }
    @Override
    public List<Product> getProductsBySize(String size) throws IProductServiceException{
        List<Product> product = product_Repo.findBySizevar(size);
        if(product.isEmpty()) {
            throw new IProductServiceException("No Exception");
        }
        else {
        return product;
        }
    }
    @Override
    public List<Product> getProductsByPrice(double price) throws IProductServiceException{
        List<Product> product =  product_Repo.findByMrp(price);
        if(product.isEmpty()) {
            throw new IProductServiceException("No Exception");
        }
        else {
        return product;
        }
    }
    @Override
    public List<Product> getProductsByColor(String color) throws IProductServiceException{
        List<Product> product = product_Repo.findByColor(color);
        if(product.isEmpty()) {
            throw new IProductServiceException("No Exception");
        }
        else {
        return product; 
        }
    }

 

}
 
