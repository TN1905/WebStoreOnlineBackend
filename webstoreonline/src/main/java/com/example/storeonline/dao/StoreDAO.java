package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Store;

public interface StoreDAO extends JpaRepository<Store,Long> {
    
}
