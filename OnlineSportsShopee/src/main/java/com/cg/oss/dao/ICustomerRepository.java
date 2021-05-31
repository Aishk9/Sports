package com.cg.oss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oss.bean.Customer;
@Repository

public interface ICustomerRepository extends JpaRepository<Customer,String> {


}
