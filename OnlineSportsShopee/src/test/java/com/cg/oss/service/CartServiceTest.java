package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

 

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Cart;
import com.cg.oss.bean.Product;
import com.cg.oss.serviceexception.ICartServiceException;
import com.cg.oss.serviceexception.IProductServiceException;

 

@SpringBootTest
public class CartServiceTest {

 

    @Autowired
    ICartService cartService;

 

    @Test
    void testFindAllCart() {
        List<Cart> Cart = cartService.getAllCartDetails();
        assertEquals(3, Cart.size());
    }
    // findProductById

 

    @Test
    void testFindCartById() throws ICartServiceException  {
        Cart cart = cartService.getCartDetails(101);
        assertEquals("ball", cart.getImageName());
        assertEquals("ball", cart.getProductName());
    }

 

    @Test
    void testCreateCart() {
         Cart cart = new Cart(101,"ball","ball",2,10000,20000);
            
            Cart persistedCart = cartService.addCart(cart);
            
            assertEquals(101, persistedCart.getCartId());
            assertEquals("ball", persistedCart.getImageName());
            assertEquals("ball", persistedCart.getProductName());
            assertEquals(2, persistedCart.getQuantity());
            assertEquals(10000, persistedCart.getPrice());
            assertEquals(20000, persistedCart.getTotal());
    }

 

    @Test
    void testUpdateCart() throws ICartServiceException  {
          Cart cart = new Cart(11,"ball_image","ball",2,10000,20000);

 

        Cart persistedCart = cartService.updateCart(11, cart);

 

        assertEquals(11, persistedCart.getCartId());
        assertEquals("ball", persistedCart.getProductName());

 

    }

 

    @Test
    void testDeleteProduct() throws IProductServiceException, ICartServiceException {
        Cart cart = new Cart(101,"ball","ball",2,10000,20000);
        Cart persistedCart = cartService.deleteCart(101);
            assertEquals(101, persistedCart.getCartId());
            assertEquals("ball", persistedCart.getImageName());
            assertEquals("ball", persistedCart.getProductName());
            assertEquals(2, persistedCart.getQuantity());
            assertEquals(10000, persistedCart.getPrice());
            assertEquals(20000, persistedCart.getTotal());    

 

    }
}
 
















