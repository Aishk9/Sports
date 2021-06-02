package com.cg.oss.service;



import static org.junit.jupiter.api.Assertions.*;

 

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

 

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

 

import com.cg.oss.bean.Payment;
import com.cg.oss.serviceexception.IPaymentServiceException;

 

@SpringBootTest
public class PaymentServiceTest {

 

    @Autowired
    IPaymentService payService;

 

    @Test
    void testFindAllPayment() {
        List<Payment> Payments = payService.getAllPaymentDetails();
        assertEquals(2, Payments.size());
    }
    // findPaymentById

 

    @Test
    void testFindPaymentById() throws IPaymentServiceException {
        Payment Payment = payService.getPaymentDetails(111);
        assertEquals("DebitCard", Payment.getType());
    }

    // addEmployee
    @Test
    void testCreatePayment() {
        Payment Payment = new Payment(114,"CreditCard","Pending");

 

        Payment persistedPay = payService.addPayment(Payment);

 

        assertEquals(114, persistedPay.getPaymentId());
        assertEquals("CreditCard", persistedPay.getType());
        assertEquals("Pending", persistedPay.getStatus());
        
    }

 

    @Test
    void testUpdatePayment() throws IPaymentServiceException {
        Payment Payment = new Payment(114,"CreditCard","Complete");

 


        Payment persistedPay = payService.updatePayment(114, Payment);

 

        assertEquals(114, persistedPay.getPaymentId());
        assertEquals("CreditCard", persistedPay.getType());
        assertEquals("Complete", persistedPay.getStatus());
        
    }

 

    @Test
    void testDeletePayment() throws IPaymentServiceException {
        Payment Payment = new Payment(114,"CreditCard","Complete");

 

        payService.deletePayment(114);
        Payment persistedPay = payService.deletePayment(111);
        assertEquals(111, persistedPay.getPaymentId());
        assertEquals("CreditCard", persistedPay.getType());
        assertEquals("Complete", persistedPay.getStatus());
    }

 

}
