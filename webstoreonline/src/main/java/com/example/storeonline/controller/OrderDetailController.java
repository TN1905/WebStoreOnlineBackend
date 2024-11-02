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

import com.example.storeonline.dao.OrderDetailDAO;
import com.example.storeonline.model.OrderDetail;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailDAO orderDetailDao;

    @GetMapping("/getall")
    public ResponseEntity<List<OrderDetail>> getOrderDetailAll() throws Exception{
        try {
            List<OrderDetail> listOrderDetail = orderDetailDao.findAll();
            return ResponseEntity.ok(listOrderDetail);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getorderdetail/{orderDetailId}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable("orderDetailId") Long orderDetailId) throws Exception{
        try {
            Optional<OrderDetail> orderDetail = orderDetailDao.findById(orderDetailId);
            if(orderDetail.isPresent()){
                return ResponseEntity.ok(orderDetail.get());
            }else{
                throw new Exception("Order Detail Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createorderdetail")
    public ResponseEntity<OrderDetail> createOrderDetail(@RequestBody OrderDetail orderDetail) throws Exception{
        try {
            if(orderDetail != null){
                OrderDetail orderDetailCreate = orderDetailDao.save(orderDetail);
                return ResponseEntity.ok(orderDetailCreate);
            }else{
                throw new Exception("Order Detail miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateorderdetail")
	public ResponseEntity<OrderDetail> updateOrderDetail(@RequestBody OrderDetail orderDetail) throws Exception{
		try {
			OrderDetail orderDetailUpdate = orderDetailDao.findById(orderDetail.getOrder_detail_id()).get();
			if(orderDetailUpdate != null) {
				orderDetailDao.save(orderDetailUpdate);
				return ResponseEntity.ok(orderDetailUpdate);
			}else {
				throw new Exception("Order Detail not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteorderdetail/{orderDetailId}")
    public void deleteOrderDetailById(@PathVariable("orderDetailId") Long orderDetailId) throws Exception{
        try {
            if(orderDetailId != null){
                orderDetailDao.deleteById(orderDetailId);
            }else{
                throw new Exception("orderDetailId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
