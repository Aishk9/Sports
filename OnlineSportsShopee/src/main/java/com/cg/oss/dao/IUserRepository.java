package com.cg.oss.dao;

import org.springframework.data.jpa.repository.JpaRepository;

 

import org.springframework.stereotype.Repository;

 

import com.cg.oss.bean.User;

 

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

 

}
