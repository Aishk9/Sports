package com.cg.oss.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oss.bean.Card;

@Repository

public interface ICardRepository extends JpaRepository<Card, Integer>{
	 
}