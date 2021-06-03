package com.cg.oss.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 

import javax.validation.Valid;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Order;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IOrderService;

 

@RestController
public class IOrderController {
    @Autowired
    private IOrderService orderService;
    
    @RequestMapping(value= "/order/add", method= RequestMethod.POST)
    public Order addOrder(@Valid @RequestBody Order newOrder) {       
            return orderService.addOrder(newOrder);
    }
    
    @RequestMapping(value = "/order/remove/{id}", method = RequestMethod.DELETE)
    public Order removeProduct(@PathVariable("id") long orderId) throws ResourceNotFoundException{
        try {
            Order order2 = orderService.removeOrder(orderId);
            if(order2==null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return order2;
        }
        catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException("No Orders Found");
        }
    }
    
    @RequestMapping(value = "/order/update/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@PathVariable("id") long orderId,@Valid @RequestBody Order order) throws ResourceNotFoundException{
        try { 
            Order order1 = orderService.updateOrder(orderId, order);
            if (order1 == null) {
                throw new ResourceNotFoundException("Not Order Found");
            }
            return order1;
        } 
        catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("No Order Found");
        }
    }
    
    
    
    @RequestMapping(value ="/order/{orderId}", method = RequestMethod.GET)
    public Order getOrderDetails(@PathVariable Long orderId) throws ResourceNotFoundException{
        try {
            Order order = orderService.getOrderDetails(orderId);
            if(order==null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return order;
        }
        catch(ResourceNotFoundException e) {
            throw new ResourceNotFoundException("No Orders Found");
        }
    }
    
    @RequestMapping(value="/order/all", method=RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
     
        ex.getBindingResult().getFieldErrors().forEach(error -> 
            errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }
}    