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

import com.example.storeonline.dao.ProductDAO;
import com.example.storeonline.model.Product;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/product")
public class ProductController {
    @Autowired
    ProductDAO productDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Product>> getProductAll() throws Exception{
        try {
            List<Product> listProduct = productDao.findAll();
            return ResponseEntity.ok(listProduct);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getproduct/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable("productId") String productId) throws Exception{
        try {
            Optional<Product> product = productDao.findById(productId);
            if(product.isPresent()){
                return ResponseEntity.ok(product.get());
            }else{
                throw new Exception("Product Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createproduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws Exception{
        try {
            if(product != null){
                Product productCreate = productDao.save(product);
                return ResponseEntity.ok(productCreate);
            }else{
                throw new Exception("Product miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateproduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) throws Exception{
		try {
			Product productUpdate = productDao.findById(product.getProduct_id()).get();
			if(productUpdate != null) {
				productDao.save(productUpdate);
				return ResponseEntity.ok(productUpdate);
			}else {
				throw new Exception("Product not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteproduct/{productId}")
    public void deleteProductById(@PathVariable("productId") String productId) throws Exception{
        try {
            if(productId != null){
                productDao.deleteById(productId);
            }else{
                throw new Exception("productId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
