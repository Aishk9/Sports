package com.cg.oss.serviceimpl;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 

import com.cg.oss.bean.Order;
import com.cg.oss.exception.ResourceNotFoundException;
import com.cg.oss.service.IOrderService;
import com.cg.oss.dao.IOrderRepository;

 


@Service
public class IOrderServiceImpl implements IOrderService {

 

    @Autowired
    private IOrderRepository orderRepository;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
       LocalDate now = LocalDate.now();

 

    @Override
    public Order addOrder(Order order) {
        order.setBillingDate(now);
        return orderRepository.save(order);
    }
    
    @Override
    public Order removeOrder(long id) throws ResourceNotFoundException{
         Optional<Order> order = orderRepository.findById(id);
            if(!order.isPresent()) {
                throw new ResourceNotFoundException("Order not found") ;
            }
           orderRepository.delete(order.get());
           return order.get();
    }

 

    @Override
    public Order updateOrder(long orderId, Order order) throws ResourceNotFoundException {
        
          Optional<Order> order1 =  orderRepository.findById(orderId);
            if (!order1.isPresent()) {
                throw new ResourceNotFoundException("No Exception");
            }
            else  {
                order.setOrderId(orderId);
                         return orderRepository.save(order);
            }
    }
    
    @Override
    public Order getOrderDetails(long id) throws ResourceNotFoundException {
        Optional<Order> order = orderRepository.findById(id);
        if(!order.isPresent()) {
            throw new ResourceNotFoundException("Order not found") ;
        }
        return order.get();
    }

 

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

 

}
 









