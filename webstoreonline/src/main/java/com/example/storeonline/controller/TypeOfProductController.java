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

import com.example.storeonline.dao.TypeOfProductDAO;
import com.example.storeonline.model.TypeOfProduct;




@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/tofp")
public class TypeOfProductController {
    @Autowired
    TypeOfProductDAO tofpDao;

    @GetMapping("/getall")
    public ResponseEntity<List<TypeOfProduct>> getTypeOfProductAll() throws Exception{
        try {
            List<TypeOfProduct> listTofP = tofpDao.findAll();
            return ResponseEntity.ok(listTofP);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/gettofp/{tofpId}")
    public ResponseEntity<TypeOfProduct> getTypeofProductById(@PathVariable("tofpId") String tofpId) throws Exception{
        try {
            Optional<TypeOfProduct> tOfP = tofpDao.findById(tofpId);
            if(tOfP.isPresent()){
                return ResponseEntity.ok(tOfP.get());
            }else{
                throw new Exception("Type Of Product Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createtofp")
    public ResponseEntity<TypeOfProduct> createTypeOfProduct(@RequestBody TypeOfProduct tOfP) throws Exception{
        try {
            if(tOfP != null){
                TypeOfProduct tOfProduct = tofpDao.save(tOfP);
                return ResponseEntity.ok(tOfProduct);
            }else{
                throw new Exception("Type Of Product miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatetofproduct")
	public ResponseEntity<TypeOfProduct> updateTypeOfProduct(@RequestBody TypeOfProduct typeOfProduct) throws Exception{
		try {
			TypeOfProduct typeOfProductUpdate = tofpDao.findById(typeOfProduct.getType_of_product_id()).get();		
			if(typeOfProductUpdate != null) {
				tofpDao.save(typeOfProductUpdate);
				return ResponseEntity.ok(typeOfProductUpdate);
			}else {
				throw new Exception("Type Of Product not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletetofproduct/{tofpId}")
    public void deleteTypeOfProductById(@PathVariable("tofpId") String tofpId) throws Exception{
        try {
            if(tofpId != null){
                tofpDao.deleteById(tofpId);
            }else{
                throw new Exception("tofpId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
}
