package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

 

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Product;
import com.cg.oss.serviceexception.IProductServiceException;

 

@SpringBootTest
public class ProductServiceTest {

 

    @Autowired
    IProductService productService;

    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate date = LocalDate.parse("11/07/1999", format);

    @Test
    void testFindAllProductss() {
        List<Product> Products = productService.getAllProduct();
        assertEquals(1, Products.size());
    }
    // findProductById

 

    @Test
    void testFindProductById() throws IProductServiceException {
        Product product = productService.getProduct(11);
        assertEquals("ball", product.getProductName());
        assertEquals("cricket", product.getCategory());
    }

 

    // findProductByName
    @Test
    void testFindProductByName() throws IProductServiceException {
        List<Product> product = productService.getProductsByName("ball");
        assertEquals(1, product.size());
    }

 

    @Test
    void testFindProductBySize_var() throws IProductServiceException {
        List<Product> product = productService.getProductsBySize("m");
        assertEquals(1, product.size());
    }

 

    @Test
    void testFindProductByColor() throws IProductServiceException {
        List<Product> product = productService.getProductsByColor("red");
        assertEquals(1, product.size());
    }

 

    @Test
    void testFindProductByPrice() throws IProductServiceException {
        List<Product> product = productService.getProductsByPrice(3000);
        assertEquals(1, product.size());
    }

 

    @Test
    void testCreateProduct() {
        Product product = new Product(111, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 20, 25000,
              date);

 

        Product persistedProduct = productService.addProduct(product);

 

        assertEquals(111, persistedProduct.getProductId());
        assertEquals("ball", persistedProduct.getProductName());
        assertEquals("cricket", persistedProduct.getCategory());
        assertEquals("lava", persistedProduct.getBrand());
        assertEquals("red", persistedProduct.getColor());
        assertEquals("XL", persistedProduct.getproductSize());
        assertEquals(30000, persistedProduct.getMrp());
        assertEquals(20, persistedProduct.getDiscount());
        assertEquals(24000, persistedProduct.getPriceAfterDiscount());
        assertEquals(LocalDate.parse("2020/09/11"), persistedProduct.getEstimatedDelivery());
    }

 

    @Test
    void testUpdateProduct() throws IProductServiceException {
        Product product = new Product(11, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 25, 25000,
              date);

 


        Product persistedProduct = productService.updateProduct(11, product);

 

        assertEquals(11, persistedProduct.getProductId());
        assertEquals("ball", persistedProduct.getProductName());
        assertEquals("cricket", persistedProduct.getCategory());
        assertEquals("lava", persistedProduct.getBrand());
        assertEquals("red", persistedProduct.getColor());
        assertEquals("XL", persistedProduct.getproductSize());
        assertEquals(30000, persistedProduct.getMrp());
        assertEquals(20, persistedProduct.getDiscount());
        assertEquals(25000, persistedProduct.getPriceAfterDiscount());
        assertEquals(LocalDate.parse("2020/09/11"), persistedProduct.getEstimatedDelivery());

 

    }

 

    @Test
    void testDeleteProduct() throws IProductServiceException {
        Product product = new Product(11, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 25, 25000,
              date);

 

        productService.removeProduct(11);
        Product persistedProduct = productService.removeProduct(112);
        assertEquals(11, persistedProduct.getProductId());
        assertEquals("ball", persistedProduct.getProductName());
        assertEquals("cricket", persistedProduct.getCategory());
        assertEquals("lava", persistedProduct.getBrand());
        assertEquals("red", persistedProduct.getColor());
        assertEquals("XL", persistedProduct.getproductSize());
        assertEquals(30000, persistedProduct.getMrp());
        assertEquals(20, persistedProduct.getDiscount());
        assertEquals(25000, persistedProduct.getPriceAfterDiscount());
        assertEquals(date, persistedProduct.getEstimatedDelivery());

 

    }

 

}