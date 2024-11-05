package com.example.storeonline.service;

import org.springframework.stereotype.Service;

import com.example.storeonline.model.EmailInfo;

import jakarta.mail.MessagingException;

@Service
public interface EmailService {
    void send(EmailInfo mail) throws MessagingException;
}
