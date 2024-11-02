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

import com.example.storeonline.dao.PaymentDAO;
import com.example.storeonline.model.Payment;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/payment")
public class PaymentController {
    @Autowired
    PaymentDAO paymentDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Payment>> getPaymentAll() throws Exception{
        try {
            List<Payment> listPayment = paymentDao.findAll();
            return ResponseEntity.ok(listPayment);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getpayment/{paymentId}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("paymentId") Long paymentId) throws Exception{
        try {
            Optional<Payment> payment = paymentDao.findById(paymentId);
            if(payment.isPresent()){
                return ResponseEntity.ok(payment.get());
            }else{
                throw new Exception("Payment Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createpayment")
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) throws Exception{
        try {
            if(payment != null){
                Payment paymentCreate = paymentDao.save(payment);
                return ResponseEntity.ok(paymentCreate);
            }else{
                throw new Exception("Payment miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updatepayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment) throws Exception{
		try {
			Payment paymentUpdate = paymentDao.findById(payment.getPayment_id()).get();
			if(paymentUpdate != null) {
				paymentDao.save(paymentUpdate);
				return ResponseEntity.ok(paymentUpdate);
			}else {
				throw new Exception("Payment not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deletepayment/{paymentId}")
    public void deleteTypeOfProductById(@PathVariable("paymentId") Long paymentId) throws Exception{
        try {
            if(paymentId != null){
                paymentDao.deleteById(paymentId);
            }else{
                throw new Exception("paymentId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
