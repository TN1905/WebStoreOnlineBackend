package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Sessions;

public interface SessionsDAO extends JpaRepository<Sessions,String> {
    
}
