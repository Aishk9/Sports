package com.cg.oss.service;


import static org.junit.jupiter.api.Assertions.*;

 


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

 

import com.cg.oss.bean.Payment;
import com.cg.oss.dao.IPaymentRepository;
import com.cg.oss.serviceexception.IPaymentServiceException;
import com.cg.oss.serviceimpl.IPaymentServiceImpl;

 

@ExtendWith(SpringExtension.class)
class PaymentServiceMockitoTest {

 

    // Mock - imitating
    // DB -
    // Product -

 

    // @InjectMock - injects PaymentService and inject dependent classes/interfaces
    // that are annotated with @Mock
    @InjectMocks
    IPaymentServiceImpl payService;

 

    // @MockBean - injecting external services

 

    @MockBean
    IPaymentRepository payRepo;

 

    // Initialization of mock objects
    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
    }

 

    @Test
    void testCreatePayment() {
        Payment payment = new Payment(113, "DebitCard", "Pending");
        
        Mockito.when(payRepo.save(payment)).thenReturn(payment);
        
        Payment persistedPay = payService.addPayment(payment); 
        
       
        
        assertEquals(113, persistedPay.getPaymentId());
        assertEquals("DebitCard", persistedPay.getType());
        assertEquals("Pending", persistedPay.getStatus());
    }
    
    @Test
    void testPaymentById() throws IPaymentServiceException {
        Payment Payment = new Payment(113, "DebitCard", "Pending");
        
        Mockito.when(payRepo.findById((long)113)).thenReturn(Optional.of(Payment));
        
        Payment persistedPay = payService.getPaymentDetails(113);
        
        assertEquals(113, persistedPay.getPaymentId());
        assertEquals("DebitCard", persistedPay.getType());
        assertEquals("Pending", persistedPay.getStatus());
    }
    
    @Test
    void testAllPayments() {
        Payment Payment1 = new Payment(111, "DebitCard", "Pending");
        Payment Payment2 = new Payment(112, "CreditCard", "Pending");
        Payment Payment3 = new Payment(113, "DebitCard", "Pending");
        
        List<Payment> PaymentList = new ArrayList<>();
        PaymentList.add(Payment1);
        PaymentList.add(Payment2);
        PaymentList.add(Payment3);
        
        Mockito.when(payRepo.findAll()).thenReturn(PaymentList);
        
        List<Payment> Payments = payService.getAllPaymentDetails();
        
        assertEquals(3, Payments.size());
        
    }
    
    @Test
    void testUpdatePayment() {
        Payment Payment = new Payment(113, "DebitCard", "Complete");
        
        Mockito.when(payRepo.findById((long)113)).thenReturn(Optional.of(Payment));
        Mockito.when(payRepo.save(Payment)).thenReturn(Payment);
        
        Payment persistedPay = payService.updatePayment(113,Payment);
        
        assertEquals(113, persistedPay.getPaymentId());
        assertEquals("DebitCard", persistedPay.getType());
        assertEquals("Complete", persistedPay.getStatus());
    }
    
    @Test
    void testDeletePayment() throws IPaymentServiceException {
        Payment Payment = new Payment(113, "DebitCard", "Complete");
        
        Mockito.when(payRepo.findById((long)113)).thenReturn(Optional.of(Payment));
        payRepo.deleteById((long)113);
        Payment persistedPay = payService.deletePayment(113);
        
        assertEquals(113, persistedPay.getPaymentId());
        assertEquals("DebitCard", persistedPay.getType());
        assertEquals("Complete", persistedPay.getStatus());
    }
    

 

}