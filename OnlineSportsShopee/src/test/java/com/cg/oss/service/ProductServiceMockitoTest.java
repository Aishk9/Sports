package com.cg.oss.service;


import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

 

import com.cg.oss.bean.Product;
import com.cg.oss.dao.IProductRepository;
import com.cg.oss.serviceexception.IProductServiceException;
import com.cg.oss.serviceimpl.IProductServiceImpl;

 

@ExtendWith(SpringExtension.class)
public class ProductServiceMockitoTest {

 

    @InjectMocks
    IProductServiceImpl productService;

 

    // @MockBean - injecting external services

 

    @MockBean
    IProductRepository productRepo;

 

    // Initialization of mock objects
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

 

    @Test
    void testCreateProduct() {
        Product product = new Product(111, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 20, 25000,
                LocalDate.parse("2020/09/11"));

 

        Product persistedProduct = productRepo.save(product);

 

        assertEquals(111, persistedProduct.getProductId());
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
    void testProductById() throws IProductServiceException {
        Product product = new Product(113, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 20, 25000,
                LocalDate.parse("2020/09/11"));

 

        Mockito.when(productRepo.findById((long) 111)).thenReturn(Optional.of(product));

 

        Product persistedProduct = productService.getProduct(111);
        assertEquals(113, persistedProduct.getProductId());
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
    void testAllCart() {
        Product product1 = new Product(111, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 25, 25000,
                LocalDate.parse("2020/09/11"));
        Product product2 = new Product(112, "bat", "cricket", "bat", "lava", "white", "L", 10000, 25, 5000,
                LocalDate.parse("2020/09/11"));
        Product product3 = new Product(113, "bat", "cricket", "bat", "lava", "yello", "M", 20000, 25, 15000,
                LocalDate.parse("2020/09/11"));

 

        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);

 

        Mockito.when(productRepo.findAll()).thenReturn(productList);

 

        List<Product> products = productService.getAllProduct();

 

        assertEquals(3, products.size());

 

    }

 

    @Test
    void testUpdateCart() throws IProductServiceException {
        Product product = new Product(112, "ball", "cricket", "ball", "lava", "red", "XL", 30000, 25, 25000,
                LocalDate.parse("2020/09/11"));

 

        Mockito.when(productRepo.findById((long) 112)).thenReturn(Optional.of(product));
        Mockito.when(productRepo.save(product)).thenReturn(product);

 

        Product persistedProduct = productService.updateProduct(112, product);

 

        assertEquals(112, persistedProduct.getProductId());
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
        void testDeleteCart() throws IProductServiceException {
            Product product = new Product(112,"ball","cricket","ball","lava","red","XL", 30000, 25, 25000, LocalDate.parse("2020/09/11"));
            
            Mockito.when(productRepo.findById((long)112)).thenReturn(Optional.of(product));
            productRepo.deleteById((long)112);
            Product persistedProduct = productService.removeProduct(112);
                    assertEquals(112, persistedProduct.getProductId());
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

 

}