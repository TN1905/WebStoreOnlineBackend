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

import com.example.storeonline.dao.RolesDAO;
import com.example.storeonline.model.Roles;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/role")
public class RolesController {
    @Autowired
    RolesDAO rolesDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Roles>> getRolesAll() throws Exception{
        try {
            List<Roles> listRoles = rolesDao.findAll();
            return ResponseEntity.ok(listRoles);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getrole/{roleId}")
    public ResponseEntity<Roles> getRoleById(@PathVariable("roleId") Integer roleId) throws Exception{
        try {
            Optional<Roles> role = rolesDao.findById(roleId);
            if(role.isPresent()){
                return ResponseEntity.ok(role.get());
            }else{
                throw new Exception("Role Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createrole")
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) throws Exception{
        try {
            if(role != null){
                Roles roleCreate = rolesDao.save(role);
                return ResponseEntity.ok(roleCreate);
            }else{
                throw new Exception("Role miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updaterole")
	public ResponseEntity<Roles> updateRole(@RequestBody Roles role) throws Exception{
		try {
			Roles roleUpdate = rolesDao.findById(role.getRole_id()).get();
			if(roleUpdate != null) {
				rolesDao.save(roleUpdate);
				return ResponseEntity.ok(roleUpdate);
			}else {
				throw new Exception("Role not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleterole/{roleId}")
    public void deleteRoleById(@PathVariable("roleId") Integer roleId) throws Exception{
        try {
            if(roleId != null){
                rolesDao.deleteById(roleId);
            }else{
                throw new Exception("roleId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
