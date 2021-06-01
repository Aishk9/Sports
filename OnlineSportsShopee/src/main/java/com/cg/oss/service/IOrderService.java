package com.cg.oss.service;

import java.util.List;



import com.cg.oss.bean.Order;
import com.cg.oss.serviceexception.IOrderServiceException;

 

public interface IOrderService {
    public Order addOrder(Order order);
    public Order removeOrder(long id) throws IOrderServiceException;
    public Order  updateOrder(long id, Order order) throws IOrderServiceException;
    public Order getOrderDetails(long id) throws IOrderServiceException ;
    public List<Order> getAllOrders(); 
}