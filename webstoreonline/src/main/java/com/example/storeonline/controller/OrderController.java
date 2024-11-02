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

import com.example.storeonline.dao.OrderDAO;
import com.example.storeonline.model.Order;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/order")
public class OrderController {
    @Autowired
    OrderDAO orderDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Order>> getOrderAll() throws Exception{
        try {
            List<Order> listOrder = orderDao.findAll();
            return ResponseEntity.ok(listOrder);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<Order> getOrderById(@PathVariable("orderId") Long orderId) throws Exception{
        try {
            Optional<Order> order = orderDao.findById(orderId);
            if(order.isPresent()){
                return ResponseEntity.ok(order.get());
            }else{
                throw new Exception("Order Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createorder")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) throws Exception{
        try {
            if(order != null){
                Order orderCreate = orderDao.save(order);
                return ResponseEntity.ok(orderCreate);
            }else{
                throw new Exception("Order miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateorder")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) throws Exception{
		try {
			Order orderUpdate = orderDao.findById(order.getOrder_id()).get();
			if(orderUpdate != null) {
				orderDao.save(orderUpdate);
				return ResponseEntity.ok(orderUpdate);
			}else {
				throw new Exception("Order not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteorder/{orderId}")
    public void deleteOrderById(@PathVariable("orderId") Long orderId) throws Exception{
        try {
            if(orderId != null){
                orderDao.deleteById(orderId);
            }else{
                throw new Exception("orderId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
