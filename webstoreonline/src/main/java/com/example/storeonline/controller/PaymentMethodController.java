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

import com.example.storeonline.dao.PaymentMethodDAO;
import com.example.storeonline.model.PaymentMethod;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/paymentmethod")
public class PaymentMethodController {
    @Autowired
    PaymentMethodDAO paymentMethodDao;

    @GetMapping("/getall")
    public ResponseEntity<List<PaymentMethod>> getPaymentMethodAll() throws Exception{
        try {
            List<PaymentMethod> listPaymentMethod = paymentMethodDao.findAll();
            return ResponseEntity.ok(listPaymentMethod);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getpaymentmethod/{paymentMethodId}")
    public ResponseEntity<PaymentMethod> getPaymentMethodById(@PathVariable("paymentMethodId") Integer paymentMethodId) throws Exception{
        try {
            Optional<PaymentMethod> paymentMethod = paymentMethodDao.findById(paymentMethodId);
            if(paymentMethod.isPresent()){
                return ResponseEntity.ok(paymentMethod.get());
            }else{
                throw new Exception("Payment Method Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createpaymentmethod")
    public ResponseEntity<PaymentMethod> createPaymentMethod(@RequestBody PaymentMethod paymentMethod) throws Exception{
        try {
            if(paymentMethod != null){
                PaymentMethod paymentMethodCreate = paymentMethodDao.save(paymentMethod);
                return ResponseEntity.ok(paymentMethodCreate);
            }else{
                throw new Exception("Payment Method miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatepaymentmethod")
	public ResponseEntity<PaymentMethod> updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) throws Exception{
		try {
			PaymentMethod paymentMethodUpdate = paymentMethodDao.findById(paymentMethod.getPayment_method_id()).get();
			if(paymentMethodUpdate != null) {
				paymentMethodDao.save(paymentMethodUpdate);
				return ResponseEntity.ok(paymentMethodUpdate);
			}else {
				throw new Exception("Payment Method not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletepaymentmethod/{paymentMethodId}")
    public void deletePaymentMethodById(@PathVariable("paymentMethodId") Integer paymentMethodId) throws Exception{
        try {
            if(paymentMethodId != null){
                paymentMethodDao.deleteById(paymentMethodId);
            }else{
                throw new Exception("paymentMethodId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
