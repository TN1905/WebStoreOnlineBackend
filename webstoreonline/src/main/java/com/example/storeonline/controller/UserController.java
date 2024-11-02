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

import com.example.storeonline.dao.UserDAO;
import com.example.storeonline.model.User;




@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/user")
public class UserController {
    @Autowired
    UserDAO userDao;

    @GetMapping("/getall")
    public ResponseEntity<List<User>> getListUser() throws Exception{
        try {
            List<User> listUser = userDao.findAll();
            return ResponseEntity.ok(listUser);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getuser/{userid}")
    public ResponseEntity<User> getUserById(@PathVariable("userid") Long userId) throws Exception{
        try {
            Optional<User> user = userDao.findById(userId);
            if(user.isPresent()){
                return ResponseEntity.ok(user.get());
            }else{
                throw new Exception("User not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> postMethodName(@RequestBody User user) throws Exception{
        try {
            if(user != null){
                User userCreate = userDao.save(user);
                return ResponseEntity.ok(userCreate);
            }else{
                throw new Exception("User miss data or null");
            }          
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateuser")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception{
		try {
			User userUpdate = userDao.findById(user.getUser_id()).get();		
			if(userUpdate != null) {
				userDao.save(userUpdate);
				return ResponseEntity.ok(userUpdate);
			}else {
				throw new Exception("User not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

    @DeleteMapping("/deleteuser/{userid}")
    public void deleteUser(@PathVariable("userid") Long userId) throws Exception{
        try {
            if(userId != null){
                userDao.deleteById(userId);
            }else{
                throw new Exception("userId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    
    
}
