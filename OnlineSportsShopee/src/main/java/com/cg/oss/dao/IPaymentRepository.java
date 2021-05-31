package com.cg.oss.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oss.bean.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment, Long> {
	
}