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

import com.example.storeonline.dao.AttributeValueDAO;
import com.example.storeonline.model.AttributeValue;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/attributevalue")
public class AttributeValueController {
    @Autowired
    AttributeValueDAO attributeValueDao;

    @GetMapping("/getall")
    public ResponseEntity<List<AttributeValue>> getAttributeValueAll() throws Exception{
        try {
            List<AttributeValue> listAttributeValue = attributeValueDao.findAll();
            return ResponseEntity.ok(listAttributeValue);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getattributevalue/{attributeValueId}")
    public ResponseEntity<AttributeValue> getAttributeValueById(@PathVariable("attributeValueId") String attributeValueId) throws Exception{
        try {
            Optional<AttributeValue> attributeValue = attributeValueDao.findById(attributeValueId);
            if(attributeValue.isPresent()){
                return ResponseEntity.ok(attributeValue.get());
            }else{
                throw new Exception("Attribute Value Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createattributevalue")
    public ResponseEntity<AttributeValue> createAttributeValue(@RequestBody AttributeValue attributeValue) throws Exception{
        try {
            if(attributeValue != null){
                AttributeValue attributeValueCreate = attributeValueDao.save(attributeValue);
                return ResponseEntity.ok(attributeValueCreate);
            }else{
                throw new Exception("Attribute Value miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateattributevalue")
	public ResponseEntity<AttributeValue> updateAttributeValue(@RequestBody AttributeValue attributeValue) throws Exception{
		try {
			AttributeValue attributeValueUpdate = attributeValueDao.findById(attributeValue.getAttribute_value_id()).get();
			if(attributeValueUpdate != null) {
				attributeValueDao.save(attributeValueUpdate);
				return ResponseEntity.ok(attributeValueUpdate);
			}else {
				throw new Exception("Attribute Value not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteattributevalue/{attributeValueId}")
    public void deleteAttributeValueById(@PathVariable("attributeValueId") String attributeValueId) throws Exception{
        try {
            if(attributeValueId != null){
                attributeValueDao.deleteById(attributeValueId);
            }else{
                throw new Exception("attributeValueId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
