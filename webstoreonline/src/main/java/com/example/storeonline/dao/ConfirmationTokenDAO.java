package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.ConfirmationToken;

public interface ConfirmationTokenDAO extends JpaRepository<ConfirmationToken,Integer>{
    
}
