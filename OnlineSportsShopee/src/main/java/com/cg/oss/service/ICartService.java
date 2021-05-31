package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Cart;

 

public interface ICartService {
        public Cart addCart(Cart cart);
        public Cart deleteCart(long cartId) throws ICartServiceException;
        public Cart updateCart(long cartId, Cart cart) throws ICartServiceException;
        public Cart getCartDetails(long cartId) throws ICartServiceException;
        public List<Cart> getAllCartDetails();
}
 