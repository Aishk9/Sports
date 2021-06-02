package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

 


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Order;
import com.cg.oss.serviceexception.IOrderServiceException;
@SpringBootTest
public class OrderServiceTest  
{
    @Autowired
    IOrderService orderService;
    
    DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/yyyy");

    LocalDate date = LocalDate.parse("11/07/1999", format);
    @Test
    void testFindAllOrders()
    {
        List<Order> orders = orderService.getAllOrders();
        assertEquals(2, orders.size());
    }
    // findOrderById
    @Test
    void testFindOrderById() throws IOrderServiceException {
        Order order = orderService.getOrderDetails(11);
        assertEquals(20000, order.getAmount());
        assertEquals("creditcard", order.getPaymentMethod());
    }
    // addOrder
    @Test
    void testCreateOrder() {
        Order order = new Order(111, 1000.0,date,"Credit card");
        Order persistedOrder = orderService.addOrder(order);
        assertEquals(111, persistedOrder.getOrderId());
        assertEquals(1000.0, persistedOrder.getAmount());
        assertEquals(date, persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    
    @Test
    void testUpdateOrder() throws IOrderServiceException {
        Order order = new Order(11, 2000.0,date, "Credit card");
        Order persistedOrder = orderService.updateOrder(112, order);
        assertEquals(11, persistedOrder.getOrderId());
        assertEquals(2000.0, persistedOrder.getAmount());
        assertEquals(date, persistedOrder.getBillingDate());
        assertEquals("Mark", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    @Test
    void testDeleteOrder() throws IOrderServiceException
    {
        Order order = new Order(11, 2000.0,date, "Credit card");

 

        orderService.removeOrder(11);
        Order persistedOrder = orderService.removeOrder(112);
        assertEquals(11, persistedOrder.getOrderId());
    }
}

 