package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.TypeOfProduct;

public interface TypeOfProductDAO extends JpaRepository<TypeOfProduct,String> {
    
}
