package com.cg.oss.repository;





import static org.junit.jupiter.api.Assertions.assertEquals;



import java.time.LocalDate;

 

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

 

import com.cg.oss.bean.Product;
import com.cg.oss.dao.IProductRepository;

 

public class ProductRepositoryTest {
    @Autowired
    IProductRepository productRepo;
    
    @Test
    void testCreateProduct() {
        
        Product product = new Product(111,"ball","cricket","ball","lava","red",
                "XL", 30000, 20, 25000, LocalDate.parse("2020/09/11"));
        
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
}