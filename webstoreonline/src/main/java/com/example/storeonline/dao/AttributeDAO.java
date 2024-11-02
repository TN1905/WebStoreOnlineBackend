package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Attribute;

public interface AttributeDAO extends JpaRepository<Attribute,String>{
    
}
