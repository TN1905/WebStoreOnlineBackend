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

import com.example.storeonline.dao.ImageDAO;
import com.example.storeonline.model.Image;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/image")
public class ImageController {
    @Autowired
    ImageDAO imageDao;

    @GetMapping("/getall")
    public ResponseEntity<List<Image>> getImageAll() throws Exception{
        try {
            List<Image> listImage = imageDao.findAll();
            return ResponseEntity.ok(listImage);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @GetMapping("/getimage/{imageId}")
    public ResponseEntity<Image> getImageById(@PathVariable("imageId") String imageId) throws Exception{
        try {
            Optional<Image> image = imageDao.findById(imageId);
            if(image.isPresent()){
                return ResponseEntity.ok(image.get());
            }else{
                throw new Exception("Image Not Found!!");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/createimage")
    public ResponseEntity<Image> createImage(@RequestBody Image image) throws Exception{
        try {
            if(image != null){
                Image imageCreate = imageDao.save(image);
                return ResponseEntity.ok(imageCreate);
            }else{
                throw new Exception("Image miss data or null");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PutMapping("/updateimage")
	public ResponseEntity<Image> updateImage(@RequestBody Image image) throws Exception{
		try {
			Image imageUpdate = imageDao.findById(image.getImage_id()).get();
			if(imageUpdate != null) {
				imageDao.save(imageUpdate);
				return ResponseEntity.ok(imageUpdate);
			}else {
				throw new Exception("Image not found!!");
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
    
    @DeleteMapping("/deleteimage/{imageId}")
    public void deleteImageById(@PathVariable("imageId") String imageId) throws Exception{
        try {
            if(imageId != null){
                imageDao.deleteById(imageId);
            }else{
                throw new Exception("imageId not found");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
