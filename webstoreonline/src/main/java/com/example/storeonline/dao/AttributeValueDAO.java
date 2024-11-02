package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.AttributeValue;

public interface AttributeValueDAO extends JpaRepository<AttributeValue,String>{
    
}
