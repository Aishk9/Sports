package com.cg.oss.repository;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cg.oss.bean.Payment;
import com.cg.oss.dao.IPaymentRepository;

public class PaymentRepositoryTest {
@Autowired
IPaymentRepository payRepo;

@Test
void testCreatePayment() {
    Payment payment = new Payment(111, "DebitCard", "Pending");
   
    Payment persistedPay = payRepo.save(payment);
   
    assertEquals(111, persistedPay.getPaymentId());
    assertEquals("DebitCard", persistedPay.getType());
    assertEquals("Pending", persistedPay.getStatus());
}
}