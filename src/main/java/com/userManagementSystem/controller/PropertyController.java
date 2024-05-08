package com.userManagementSystem.controller;

import com.userManagementSystem.entity.Property;
import com.userManagementSystem.payload.PropertyDto;
import com.userManagementSystem.repository.PropertyRepository;
import com.userManagementSystem.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    private PropertyService propertyService;

    private PropertyRepository propertyRepository;

    public PropertyController(PropertyService propertyService, PropertyRepository propertyRepository) {
        this.propertyService = propertyService;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/addProperty")
    public ResponseEntity<Property> addProperty(@RequestBody Property property){
        Property save = propertyRepository.save(property);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }
}
