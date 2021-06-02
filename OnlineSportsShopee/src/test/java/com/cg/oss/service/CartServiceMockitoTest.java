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

 

import com.cg.oss.bean.Cart;
import com.cg.oss.bean.Product;
import com.cg.oss.dao.ICartRepository;
import com.cg.oss.serviceexception.ICartServiceException;
import com.cg.oss.serviceimpl.ICartServiceImpl;

 


@ExtendWith(SpringExtension.class)
public class CartServiceMockitoTest {

 

    @InjectMocks
    ICartServiceImpl cartService;

 

    // @MockBean - injecting external services

 

    @MockBean
    ICartRepository cartRepo;

 

    // Initialization of mock objects
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

 

    @Test
    void testCreateCart() {
      Cart cart = new Cart(11,"ball","ball",2,10000,20000);
        
        Cart persistedCart = cartService.addCart(cart);
        
        assertEquals(11, persistedCart.getCartId());
        assertEquals("ball", persistedCart.getImageName());
        assertEquals("ball", persistedCart.getProductName());
        assertEquals(2, persistedCart.getQuantity());
        assertEquals(10000, persistedCart.getPrice());
        assertEquals(20000, persistedCart.getTotal());
    }

 

    @Test
    void testCartById() throws ICartServiceException {
        Cart cart = new Cart(111,"ball","ball",2,10000,20000);
      Mockito.when(cartRepo.findById((long) 111)).thenReturn(Optional.of(cart));
        Cart persistedCart = cartService.getCartDetails(111);
        
        assertEquals(111, persistedCart.getCartId());
        assertEquals("ball", persistedCart.getImageName());
        assertEquals("ball", persistedCart.getProductName());
        assertEquals(2, persistedCart.getQuantity());
        assertEquals(10000, persistedCart.getPrice());
        assertEquals(20000, persistedCart.getTotal());

 

    }

 

    @Test
    void testAllCart() {
          Cart cart1 = new Cart(111,"ball","ball",2,10000,20000);
          Cart cart2 = new Cart(112,"bat","bat",2,5000,10000);
          Cart cart3 = new Cart(113,"bat","bat",2,5000,10000);

 

        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart1);
        cartList.add(cart1);
        cartList.add(cart1);

 

        Mockito.when(cartRepo.findAll()).thenReturn(cartList);

 

        List<Cart> cart = cartService.getAllCartDetails();

 

        assertEquals(3, cart.size());

 

    }

 

    @Test
    void testUpdateCart() throws ICartServiceException {
          Cart cart = new Cart(111,"ball","ball",2,10000,20000);
          Mockito.when(cartRepo.findById((long) 111)).thenReturn(Optional.of(cart));

 

            Mockito.when(cartRepo.save(cart)).thenReturn(cart);

 


        Cart persistedCart = cartService.updateCart(111, cart);

 

        assertEquals(111, persistedCart.getCartId());
        assertEquals("ball", persistedCart.getImageName());
        assertEquals("ball", persistedCart.getProductName());
        assertEquals(2, persistedCart.getQuantity());
        assertEquals(10000, persistedCart.getPrice());
        assertEquals(20000, persistedCart.getTotal());

 

    }

 

    @Test
        void testDeleteCart() throws ICartServiceException {
         Cart cart = new Cart(111,"ball","ball",2,10000,20000);
          Mockito.when(cartRepo.findById((long) 111)).thenReturn(Optional.of(cart));
            cartRepo.deleteById((long)112);
            Cart persistedCart = cartService.deleteCart(111);
            assertEquals(111, persistedCart.getCartId());
            assertEquals("ball", persistedCart.getImageName());
            assertEquals("ball", persistedCart.getProductName());
            assertEquals(2, persistedCart.getQuantity());
            assertEquals(10000, persistedCart.getPrice());
            assertEquals(20000, persistedCart.getTotal());        
            
        }
}
 
