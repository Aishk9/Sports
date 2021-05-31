package com.cg.oss.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Cart;
import com.cg.oss.bean.Product;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.ICartService;
import com.cg.oss.service.ICartServiceException;
import com.cg.oss.service.IProductService;
import com.cg.oss.service.IProductServiceException;

 

@RestController
public class ICartController {

 

    @Autowired
    private ICartService cartService;
    

 

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public Cart addCart(@RequestBody Cart cart) {
        int quantity = cart.getQuantity();
        double sum =0;
        for(int i=1;i<=quantity;i++) {
            sum = sum + cart.getPrice();
        }
        cart.setTotal(sum);
        return cartService.addCart(cart);
    }

 

    @RequestMapping(value = "/cart/{id}", method = RequestMethod.DELETE)
    public Cart deleteCart(@PathVariable("id") long cartId) throws ResourceNotFoundException, ICartServiceException{
        try { 
            Cart Cart = cartService.deleteCart(cartId);
            if (Cart == null) {
                throw new ResourceNotFoundException("Not Cart Found");
            }
            return Cart;
        } catch (ICartServiceException e) {
            throw new ICartServiceException("No Carts Found");
        }
    }

 

    @RequestMapping(value = "/cart/update/{id}", method = RequestMethod.PUT)
    public Cart updateCart(@PathVariable("id") long cartId, @RequestBody Cart cart) throws ResourceNotFoundException, ICartServiceException{
        try { 
            Cart Cart1 = cartService.updateCart(cartId, cart);
            if (Cart1 == null) {
                throw new ResourceNotFoundException("Not Cart Found");
            }
            return Cart1;
        } catch (ICartServiceException e) {
            throw new ICartServiceException("No Carts Found");
        }
    }

 

    @RequestMapping(value = "/card/get/{id}", method = RequestMethod.GET)
    public Cart getCartDetails(@PathVariable("name") long cartId) throws ResourceNotFoundException, ICartServiceException{
        try { 
            Cart Cart = cartService.getCartDetails(cartId);
            if (Cart == null) {
                throw new ResourceNotFoundException("Not Cart Found");
            }
            return Cart;
        } catch (ICartServiceException e) {
            throw new ICartServiceException("No Carts Found");
        }
    }

 

    @RequestMapping(value = "/cart/all", method = RequestMethod.GET)
    public List<Cart> getAllCartDetails() {
        return cartService.getAllCartDetails(); 
    }
}