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

import com.example.storeonline.dao.ShippingMethodDAO;
import com.example.storeonline.model.ShippingMethod;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/shippingmethod")
public class ShippingMethodController {
    @Autowired
    ShippingMethodDAO shippingMethodDao;

    @GetMapping("/getall")
    public ResponseEntity<List<ShippingMethod>> getShippingMethodAll() throws Exception{
        try {
            List<ShippingMethod> listShippingMethod = shippingMethodDao.findAll();
            return ResponseEntity.ok(listShippingMethod);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getshippingmethod/{shippingMethodId}")
    public ResponseEntity<ShippingMethod> getShippingMethodById(@PathVariable("shippingMethodId") Integer shippingMethodId) throws Exception{
        try {
            Optional<ShippingMethod> shippingMethod = shippingMethodDao.findById(shippingMethodId);
            if(shippingMethod.isPresent()){
                return ResponseEntity.ok(shippingMethod.get());
            }else{
                throw new Exception("Shipping Method Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createshippingmethod")
    public ResponseEntity<ShippingMethod> createShippingMethod(@RequestBody ShippingMethod shippingMethod) throws Exception{
        try {
            if(shippingMethod != null){
                ShippingMethod shippingMethodCreate = shippingMethodDao.save(shippingMethod);
                return ResponseEntity.ok(shippingMethodCreate);
            }else{
                throw new Exception("Shipping Method miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateshippingmethod")
	public ResponseEntity<ShippingMethod> updateShippingMethod(@RequestBody ShippingMethod shippingMethod) throws Exception{
		try {
			ShippingMethod shippingMethodUpdate = shippingMethodDao.findById(shippingMethod.getShipping_method_id()).get();
			if(shippingMethodUpdate != null) {
				shippingMethodDao.save(shippingMethodUpdate);
				return ResponseEntity.ok(shippingMethodUpdate);
			}else {
				throw new Exception("Shipping Method not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteshippingmethod/{shippingMethodId}")
    public void deleteShippingMethodById(@PathVariable("shippingMethodId") Integer shippingMethodId) throws Exception{
        try {
            if(shippingMethodId != null){
                shippingMethodDao.deleteById(shippingMethodId);
            }else{
                throw new Exception("shippingMethodId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
