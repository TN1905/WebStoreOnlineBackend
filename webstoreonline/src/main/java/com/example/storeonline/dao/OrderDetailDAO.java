package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.OrderDetail;

public interface OrderDetailDAO extends JpaRepository<OrderDetail,Long>{
    
}
