package com.cg.oss.service;

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;

 

import com.cg.oss.bean.Cart;
import com.cg.oss.bean.Product;
import com.cg.oss.dao.ICartRepository;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 


@Service
public class ICartServiceImpl implements ICartService {

 

    @Autowired
    private ICartRepository cartRepo;

 

    @Override
    public Cart addCart(Cart cart) {
        Cart c = new Cart();
        c.setQuantity(c.getQuantity() + 1);
        return cartRepo.save(cart);
    }

 

    @Override
    public Cart deleteCart(long cartId) throws ICartServiceException {
        Optional<Cart> cart = cartRepo.findById(cartId);
        if (!cart.isPresent()) {
            throw new ICartServiceException("No Cart Details Found For Deletion");
        }
        cartRepo.delete(cart.get());
        return cart.get();
    }

 

    @Override
    public Cart updateCart(long cartId, Cart cart) throws ICartServiceException {
        
          Optional<Cart> cart1 =  cartRepo.findById(cartId);
            if (!cart1.isPresent()) {
                throw new ICartServiceException("No Exception");
            }
            else  {
                         cart.setCartId(cartId);
                         return cartRepo.save(cart);
            }
    }

 

    @Override
    public Cart getCartDetails(long cartId) throws ICartServiceException {
        Optional<Cart> cart = cartRepo.findById(cartId);
        if (!cart.isPresent()) {
            throw new ICartServiceException("No Cart Details Found For View Cart");
        }
        return cart.get();

 

    }

 

    @Override
    public List<Cart> getAllCartDetails() {
        // TODO Auto-generated method stub
        return cartRepo.findAll();
    }

 

}
 
