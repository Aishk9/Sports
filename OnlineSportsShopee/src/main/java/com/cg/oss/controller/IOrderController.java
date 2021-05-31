package com.cg.oss.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

 

import com.cg.oss.bean.Order;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IOrderService;
import com.cg.oss.service.IOrderServiceException;


 

@RestController
public class IOrderController {
    @Autowired
    private IOrderService orderService;
    
    @RequestMapping(value= "/order/add", method= RequestMethod.POST)
    public Order addOrder(@RequestBody Order newOrder) {       
            return orderService.addOrder(newOrder);
    }
    
    @RequestMapping(value = "/order/remove/{id}", method = RequestMethod.DELETE)
    public Order removeProduct(@PathVariable("id") long orderId) throws ResourceNotFoundException,IOrderServiceException{
        try {
            Order order2 = orderService.removeOrder(orderId);
            if(order2==null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return order2;
        }catch(IOrderServiceException e) {
            throw new IOrderServiceException("No Orders Found");
        }
    }
    
    @RequestMapping(value="/order/update/{id}", method = RequestMethod.PUT)
    public Order updateOrder(@PathVariable("id") long orderId, @RequestBody Order order) throws ResourceNotFoundException,IOrderServiceException{
        try {
            Order order1 = orderService.updateOrder(orderId, order);
            if(order1==null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return order1;
        }catch(IOrderServiceException e) {
            throw new IOrderServiceException("No Orders Found");
        }
        
    }
    
    @RequestMapping(value ="/order/{orderId}", method = RequestMethod.GET)
    public Order getOrderDetails(@PathVariable Long orderId) throws ResourceNotFoundException,IOrderServiceException{
        try {
            Order order = orderService.getOrderDetails(orderId);
            if(order==null) {
                throw new ResourceNotFoundException("Not Found");
            }
            return order;
        }catch(IOrderServiceException e) {
            throw new IOrderServiceException("No Orders Found");
        }
    }
    
    @RequestMapping(value="/order/all", method=RequestMethod.GET)
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }
}