package com.cg.oss.repository;


import static org.junit.jupiter.api.Assertions.*;



import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Order;
import com.cg.oss.dao.IOrderRepository;

 

@SpringBootTest
class OrderRepositoryTest {
    @Autowired
    IOrderRepository orderRepository;
    @Test
    void testCreateOrder() {
        Order order = new Order(111, 1000,LocalDate.parse("2020/05/06"),"Credit card");
        Order persistedOrder = orderRepository.save(order);
        assertEquals(111, persistedOrder.getOrderId());
        assertEquals(1000.0, persistedOrder.getAmount());
        assertEquals(LocalDate.parse("2020/05/06"), persistedOrder.getBillingDate());
        assertEquals("Smith", persistedOrder.getCustomer());
        assertEquals("Credit card", persistedOrder.getPaymentMethod());
        
    }
}
 