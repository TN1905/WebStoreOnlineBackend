package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Order;

public interface OrderDAO extends JpaRepository<Order,Long>{
    
}
