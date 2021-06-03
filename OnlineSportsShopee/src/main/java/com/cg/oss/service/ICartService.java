package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Cart;
import com.cg.oss.exception.ResourceNotFoundException;


 

public interface ICartService {
        public Cart addCart(Cart cart);
        public Cart deleteCart(long cartId) throws ResourceNotFoundException;
        public Cart updateCart(long cartId, Cart cart) throws ResourceNotFoundException;
        public Cart getCartDetails(long cartId) throws ResourceNotFoundException;
        public List<Cart> getAllCartDetails();
}
 