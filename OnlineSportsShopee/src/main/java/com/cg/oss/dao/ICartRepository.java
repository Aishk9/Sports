package com.cg.oss.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

 

import com.cg.oss.bean.Cart;

 

@Repository
public interface ICartRepository extends JpaRepository<Cart,Long>{

 

}
 