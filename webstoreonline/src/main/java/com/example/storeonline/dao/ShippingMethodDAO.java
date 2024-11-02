package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.ShippingMethod;

public interface ShippingMethodDAO extends JpaRepository<ShippingMethod,Integer> {
    
}
