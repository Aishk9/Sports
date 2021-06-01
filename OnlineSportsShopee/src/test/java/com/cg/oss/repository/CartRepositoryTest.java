package com.cg.oss.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

 


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

 

import com.cg.oss.bean.Cart;
import com.cg.oss.dao.ICartRepository;

 


public class CartRepositoryTest {
    @Autowired
    ICartRepository cartRepo;
    
    @Test
    void testCreateCart() {
        
        Cart cart = new Cart(101,"ball","ball",2,10000,20000);
        
        Cart persistedCart = cartRepo.save(cart);
        
        assertEquals(101, persistedCart.getCartId());
        assertEquals("ball", persistedCart.getImageName());
        assertEquals("ball", persistedCart.getProductName());
        assertEquals(2, persistedCart.getQuantity());
        assertEquals(10000, persistedCart.getPrice());
        assertEquals(20000, persistedCart.getTotal());
}
}
 




