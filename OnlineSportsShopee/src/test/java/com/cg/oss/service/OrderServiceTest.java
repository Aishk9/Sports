package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
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
    @Test
    void testFindAllOrders()
    {
        List<Order> orders = orderService.getAllOrders();
        assertEquals(3, orders.size());
    }
    // findOrderById
    @Test
    void testFindOrderById() throws IOrderServiceException {
        Order order = orderService.getOrderDetails(111);
        assertEquals(1000.0, order.getAmount());
        assertEquals("Credit card", order.getPaymentMethod());
    }
    // addOrder
    @Test
    void testCreateOrder() {
        Order order = new Order(111, 1000.0,LocalDate.parse("2020/05/06"),"Credit card");
        Order persistedOrder = orderService.addOrder(order);
        assertEquals(111, persistedOrder.getOrderId());
        assertEquals(1000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/05/06"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    
    @Test
    void testUpdateOrder() throws IOrderServiceException {
        Order order = new Order(112, 2000.0,LocalDate.parse("2020/06/01"), "Credit card");
        Order persistedOrder = orderService.updateOrder(112, order);
        assertEquals(112, persistedOrder.getOrderId());
        assertEquals(2000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/06/01"), persistedOrder.getBillingDate());
        assertEquals("Mark", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    @Test
    void testDeleteOrder() throws IOrderServiceException
    {
        Order order = new Order(112, 2000.0,LocalDate.parse("2020/06/01"), "Credit card");

 

        orderService.removeOrder(112);
        Order persistedOrder = orderService.removeOrder(112);
        assertEquals(112, persistedOrder.getOrderId());
        assertEquals(2000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/06/01"), persistedOrder.getBillingDate());
        assertEquals("Mark", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
}

 