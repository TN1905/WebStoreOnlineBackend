package com.example.storeonline.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storeonline.dao.SessionsDAO;
import com.example.storeonline.model.Sessions;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/session")
public class SessionsController {
    @Autowired
    SessionsDAO sessionDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Sessions>> getSessionAll() throws Exception{
        try {
            List<Sessions> listSessions = sessionDao.findAll();
            return ResponseEntity.ok(listSessions);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getsession/{sessionId}")
    public ResponseEntity<Sessions> getShippingMethodById(@PathVariable("sessionId") String sessionId) throws Exception{
        try {
            Optional<Sessions> session = sessionDao.findById(sessionId);
            if(session.isPresent()){
                return ResponseEntity.ok(session.get());
            }else{
                throw new Exception("Session Method Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createsession")
    public ResponseEntity<Sessions> createShippingMethod(@RequestBody Sessions session) throws Exception{
        try {
            if(session != null){
                Sessions sessionCreate = sessionDao.save(session);
                return ResponseEntity.ok(sessionCreate);
            }else{
                throw new Exception("Session miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatesession")
	public ResponseEntity<Sessions> updateSession(@RequestBody Sessions session) throws Exception{
		try {
			Sessions sessionUpdate = sessionDao.findById(session.getSession_id()).get();
			if(sessionUpdate != null) {
				sessionDao.save(sessionUpdate);
				return ResponseEntity.ok(sessionUpdate);
			}else {
				throw new Exception("Session not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletesession/{sessionId}")
    public void deleteSessionById(@PathVariable("sessionId") String sessionId) throws Exception{
        try {
            if(sessionId != null){
                sessionDao.deleteById(sessionId);
            }else{
                throw new Exception("sessionId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
