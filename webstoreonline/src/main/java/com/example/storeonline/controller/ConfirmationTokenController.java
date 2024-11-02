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

import com.example.storeonline.dao.ConfirmationTokenDAO;
import com.example.storeonline.model.ConfirmationToken;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/confirmation_token")
public class ConfirmationTokenController {
    @Autowired
    ConfirmationTokenDAO confirmationTokenDao;

    @GetMapping("/getall")
    public ResponseEntity<List<ConfirmationToken>> getConfirmationTokenAll() throws Exception{
        try {
            List<ConfirmationToken> listConfirmationToken = confirmationTokenDao.findAll();
            return ResponseEntity.ok(listConfirmationToken);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/gettoken/{tokenId}")
    public ResponseEntity<ConfirmationToken> getConfirmationTokenById(@PathVariable("tokenId") Integer tokenId) throws Exception{
        try {
            Optional<ConfirmationToken> confirmationToken = confirmationTokenDao.findById(tokenId);
            if(confirmationToken.isPresent()){
                return ResponseEntity.ok(confirmationToken.get());
            }else{
                throw new Exception("Confirmation Token Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createtoken")
    public ResponseEntity<ConfirmationToken> createConfirmationToken(@RequestBody ConfirmationToken confirmationToken) throws Exception{
        try {
            if(confirmationToken != null){
                ConfirmationToken confirmationTokenCreate = confirmationTokenDao.save(confirmationToken);
                return ResponseEntity.ok(confirmationTokenCreate);
            }else{
                throw new Exception("Confirmation Token miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatetoken")
	public ResponseEntity<ConfirmationToken> updateToken(@RequestBody ConfirmationToken confirmationToken) throws Exception{
		try {
			ConfirmationToken confirmationTokenUpdate = confirmationTokenDao.findById(confirmationToken.getConfirmation_token_id()).get();
			if(confirmationTokenUpdate != null) {
				confirmationTokenDao.save(confirmationTokenUpdate);
				return ResponseEntity.ok(confirmationTokenUpdate);
			}else {
				throw new Exception("Confirmation Token not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletetoken/{tokenId}")
    public void deleteConfirmationTokenById(@PathVariable("tokenId") Integer tokenId) throws Exception{
        try {
            if(tokenId != null){
                confirmationTokenDao.deleteById(tokenId);
            }else{
                throw new Exception("tokenId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
