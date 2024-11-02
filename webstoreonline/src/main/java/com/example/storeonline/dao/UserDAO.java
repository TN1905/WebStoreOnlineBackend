package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.User;

public interface UserDAO extends JpaRepository<User,Long> {
    
}
