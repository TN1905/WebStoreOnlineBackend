package com.example.storeonline.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storeonline.model.Roles;

public interface RolesDAO extends JpaRepository<Roles,Integer> {
    
}
