package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.PaymentMethod;

public interface PaymentMethodDAO extends JpaRepository<PaymentMethod,Integer>{
    
}
