package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Payment;

public interface PaymentDAO extends JpaRepository<Payment,Long>{
    
}
