package com.cg.oss.service;

import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

 

import com.cg.oss.bean.Order;
import com.cg.oss.dao.IOrderRepository;
import com.cg.oss.serviceexception.IOrderServiceException;
import com.cg.oss.serviceimpl.IOrderServiceImpl;

 


@ExtendWith(SpringExtension.class)
class OrderServiceMockitoTest {
    // Mock - imitating
    // DB -
    // Product -

 


    // @InjectMock - injects EmployeeService and inject dependent classes/interfaces
    // that are annotated with @Mock
    @InjectMocks
    IOrderServiceImpl orderService;

 


    // @MockBean - injecting external services

 


    @MockBean
    IOrderRepository orderRepository;

 


    // Initialization of mock objects
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

 

    @Test
    void testCreateOrder() {
        Order order = new Order(111, 1000.0,LocalDate.parse("2020/05/06"), "Credit card");

 

        Mockito.when(orderRepository.save(order)).thenReturn(order);
        
        Order persistedOrder = orderService.addOrder(order);
        
        assertEquals(111, persistedOrder.getOrderId());
        assertEquals(1000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/05/06"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    @Test
    void testOrderById() throws IOrderServiceException {
        Order order = new Order(112, 2000.0,LocalDate.parse("2020/06/01"), "Credit card");
        Mockito.when(orderRepository.findById((long) 112)).thenReturn(Optional.of(order));
        
        Order persistedOrder = orderService.getOrderDetails(112);
        
        assertEquals(111, persistedOrder.getOrderId());
        assertEquals(1000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/05/06"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
    }
    
    @Test
    void testAllOrder() {
        Order order1 = new Order(111, 1000.0,LocalDate.parse("2020/05/06"),"Credit card");
         Order order2 = new Order(112, 2000.0,LocalDate.parse("2020/06/01"),"Credit card");
        Order order3 = new Order(113, 3000.0,LocalDate.parse("2020/04/02"),"Debit card");
        List<Order> orderList = new ArrayList<>();
        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        
        Mockito.when(orderRepository.findAll()).thenReturn(orderList);
        
        List<Order> order = orderService.getAllOrders();
        
        assertEquals(3, order.size());
    }

 

    @Test
    void testUpdateOrder() throws IOrderServiceException {
        Order order = new Order(113, 3000.0,LocalDate.parse("2020/04/02"), "Debit card");
        Mockito.when(orderRepository.findById((long) 113)).thenReturn(Optional.of(order));
        Mockito.when(orderRepository.save(order)).thenReturn(order);
        
        Order persistedOrder = orderService.updateOrder(113, order);
        
        assertEquals(113, persistedOrder.getOrderId());
        assertEquals(3000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/04/02"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Debit card", persistedOrder.getPaymentMethod());
    }
    @Test
    void testDeleteOrder() throws IOrderServiceException
    {
        Order order = new Order(113, 3000.0,LocalDate.parse("2020/04/02"), "Debit card");
        Mockito.when(orderRepository.findById((long)113)).thenReturn(Optional.of(order));
        orderRepository.deleteById((long) 113);
        Order persistedOrder = orderService.removeOrder(113);
        
        assertEquals(113, persistedOrder.getOrderId());
        assertEquals(3000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/04/02"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Debit card", persistedOrder.getPaymentMethod());
    }
}