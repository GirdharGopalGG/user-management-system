package com.userManagementSystem.controller;

import com.userManagementSystem.entity.Property;
import com.userManagementSystem.repository.PropertyRepository;
import com.userManagementSystem.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {
    private final PropertyService propertyService;

    private final PropertyRepository propertyRepository;

    public PropertyController(PropertyService propertyService, PropertyRepository propertyRepository) {
        this.propertyService = propertyService;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping("/addProperty")        //USING SERVICE LAYER
    public ResponseEntity<Property> addProperty(@RequestBody Property property) {
        Property property1 = propertyService.addProperty(property);
        return new ResponseEntity<>(property1, HttpStatus.CREATED);
    }

//    @PostMapping("/addProperty")      //////////WITHOUT USING SERVICE LAYER
//    public ResponseEntity<Property> addProperty(@RequestBody Property property){
//        Property save = propertyRepository.save(property);
//        return new ResponseEntity<>(save, HttpStatus.CREATED);
//    }

    @GetMapping()
    public ResponseEntity<List<Property>> getAllProperty() {
        List<Property> all = propertyRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProperty(@PathVariable Long id) {
        try {
            propertyRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Property not found... ID doesn't exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Property Deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProperty(@PathVariable Long id, @RequestBody Property updatedProperty) {
        Property existingProperty = new Property();
        updatedProperty.setId(existingProperty.getId());
        updatedProperty.setPropertyName(existingProperty.getPropertyName());
        updatedProperty.setBathrooms(existingProperty.getBathrooms());
        updatedProperty.setGuests(existingProperty.getGuests());
        updatedProperty.setBeds(existingProperty.getBeds());
        updatedProperty.setBedrooms(existingProperty.getBedrooms());
        updatedProperty.setCountry(existingProperty.getCountry());
        updatedProperty.setNightlyPrice(existingProperty.getNightlyPrice());
        updatedProperty.setLocation(existingProperty.getLocation());
        Property save = propertyRepository.save(updatedProperty);
        return new ResponseEntity<>(save, HttpStatus.OK);

    }

    @GetMapping("/jpql")
    public ResponseEntity<List<Property>> getPropertyListings(@RequestParam String location) {
        List<Property> properties = propertyRepository.listPropertyByLocationName(location);
        return new ResponseEntity<>(properties, HttpStatus.OK);
    }


}








