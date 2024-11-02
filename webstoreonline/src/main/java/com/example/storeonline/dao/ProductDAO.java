package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Product;

public interface ProductDAO extends JpaRepository<Product,String> {
    
}
