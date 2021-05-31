package com.cg.oss.service;

import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.Order;
import com.cg.oss.dao.IOrderRepository;

 


@Service
public class IOrderServiceImpl implements IOrderService {

 

    @Autowired
    private IOrderRepository orderRepository;
    
    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
    
    @Override
    public Order removeOrder(long id) {
         Optional<Order> order = orderRepository.findById(id);
            if(!order.isPresent()) {
                return null;
            }
           orderRepository.delete(order.get());
           return order.get();
    }

 

    @Override
    public Order updateOrder(long id, Order order) {
        Optional<Order> orders = orderRepository.findById(id);
        if(!orders.isPresent()) {
            return null;
        }
        orders.get().setAmount(order.getAmount());
        //orders.get().setBillingDate(order.getBillingDate());
        //orders.get().setCustomer(order.getCustomer());
        //orders.get().setPaymentMethod(order.getPaymentMethod());
        return orderRepository.save(orders.get());
    }

 

    @Override
    public Order getOrderDetails(long id) throws IOrderServiceException {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) {
            throw new IOrderServiceException("Order not found") ;
        }
        return order.get();
    }

 

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

 

}
 