package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Image;

public interface ImageDAO extends JpaRepository<Image,String>{
    
}
