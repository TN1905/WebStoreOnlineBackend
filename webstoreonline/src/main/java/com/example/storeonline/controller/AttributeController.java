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

import com.example.storeonline.dao.AttributeDAO;
import com.example.storeonline.model.Attribute;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/attribute")
public class AttributeController {
    @Autowired
    AttributeDAO attributeDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Attribute>> getAttributeAll() throws Exception{
        try {
            List<Attribute> listAttrbute = attributeDao.findAll();
            return ResponseEntity.ok(listAttrbute);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getattribute/{attributeId}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable("attributeId") String attributeId) throws Exception{
        try {
            Optional<Attribute> attribute = attributeDao.findById(attributeId);
            if(attribute.isPresent()){
                return ResponseEntity.ok(attribute.get());
            }else{
                throw new Exception("Attribute Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createattribute")
    public ResponseEntity<Attribute> createAttribute(@RequestBody Attribute attribute) throws Exception{
        try {
            if(attribute != null){
                Attribute attributeCreate = attributeDao.save(attribute);
                return ResponseEntity.ok(attributeCreate);
            }else{
                throw new Exception("Attribute miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateattributee")
	public ResponseEntity<Attribute> updateAttribute(@RequestBody Attribute attribute) throws Exception{
		try {
			Attribute attributeUpdate = attributeDao.findById(attribute.getAttribute_id()).get();
			if(attributeUpdate != null) {
				attributeDao.save(attributeUpdate);
				return ResponseEntity.ok(attributeUpdate);
			}else {
				throw new Exception("Attribute not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteattribute/{attributeId}")
    public void deleteAttributeById(@PathVariable("attributeId") String attributeId) throws Exception{
        try {
            if(attributeId != null){
                attributeDao.deleteById(attributeId);
            }else{
                throw new Exception("attributeId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
