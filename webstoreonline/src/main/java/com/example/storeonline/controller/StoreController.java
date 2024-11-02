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

import com.example.storeonline.dao.StoreDAO;
import com.example.storeonline.model.Store;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/store")
public class StoreController {
    @Autowired
    StoreDAO storeDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Store>> getStores() throws Exception{
        try {
            List<Store> listStores = storeDao.findAll();
            return ResponseEntity.ok(listStores);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getstore/{storeId}")
    public ResponseEntity<Store> getStoreById(@PathVariable("storeId") Long storeId) throws Exception{
        try {
            Optional<Store> store = storeDao.findById(storeId);
            if(store.isPresent()){
                return ResponseEntity.ok(store.get());
            }else{
                throw new Exception("Store Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createstore")
    public ResponseEntity<Store> createStore(@RequestBody Store store) throws Exception{
        try {
            if(store != null){
                Store storeCreate = storeDao.save(store);
                return ResponseEntity.ok(storeCreate);
            }else{
                throw new Exception("Store miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatestore")
	public ResponseEntity<Store> updateStore(@RequestBody Store store) throws Exception{
		try {
			Store storeUpdate = storeDao.findById(store.getStore_id()).get();
			if(storeUpdate != null) {
				storeDao.save(storeUpdate);
				return ResponseEntity.ok(storeUpdate);
			}else {
				throw new Exception("Store not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletestore/{storeId}")
    public void deleteStoreById(@PathVariable("storeId") Long storeId) throws Exception{
        try {
            if(storeId != null){
                storeDao.deleteById(storeId);
            }else{
                throw new Exception("StoreId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
