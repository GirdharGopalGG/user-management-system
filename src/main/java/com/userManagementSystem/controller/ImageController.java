package com.userManagementSystem.controller;

import com.userManagementSystem.entity.Image;
import com.userManagementSystem.entity.Property;
import com.userManagementSystem.repository.ImageRepository;
import com.userManagementSystem.repository.PropertyRepository;
import com.userManagementSystem.service.BucketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageRepository imageRepository;
    private final PropertyRepository propertyRepository;
    private final BucketService bucketService;

    public ImageController(ImageRepository imageRepository, PropertyRepository propertyRepository, BucketService bucketService) {
        this.imageRepository = imageRepository;
        this.propertyRepository = propertyRepository;
        this.bucketService = bucketService;
    }

    public ResponseEntity<Image> addImage(@RequestParam long propertyId,
                                          MultipartFile file,
                                          @RequestParam String bucketName) {
        String imageUrl = bucketService.uploadFile(file, bucketName);
        Optional<Property> byId = propertyRepository.findById(propertyId);
        Property property = byId.get();
        Image image = new Image();
        image.setImageUrl(imageUrl);
        image.setProperty(property);
        Image save = imageRepository.save(image);
        return new ResponseEntity<>(save, HttpStatus.CREATED);


    }

}




