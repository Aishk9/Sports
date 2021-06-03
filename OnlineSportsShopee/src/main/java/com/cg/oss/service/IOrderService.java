package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Order;
import com.cg.oss.exception.ResourceNotFoundException;


 

public interface IOrderService {
    public Order addOrder(Order order);
    public Order removeOrder(long id) throws ResourceNotFoundException;
    public Order  updateOrder(long id, Order order) throws ResourceNotFoundException;
    public Order getOrderDetails(long id) throws ResourceNotFoundException ;
    public List<Order> getAllOrders(); 
}