package com.userManagementSystem.controller;

import com.userManagementSystem.entity.Location;
import com.userManagementSystem.repository.LocationRepository;
import com.userManagementSystem.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private final LocationService locationService;
    private final LocationRepository locationRepository;

    public LocationController(LocationService locationService, LocationRepository locationRepository) {
        this.locationService = locationService;
        this.locationRepository = locationRepository;
    }

//    @PostMapping("/addLocation")
//    public ResponseEntity<LocationDto> addLocation(@RequestBody LocationDto locationDto){
//        LocationDto locationDto1 = locationService.addLocation(locationDto);
//        return new ResponseEntity<>(locationDto1, HttpStatus.CREATED);
//    }

    @PostMapping("/addLocation")
    public ResponseEntity<Location> addLocation(@RequestBody Location location) {
        Location save = locationRepository.save(location);
        return new ResponseEntity<>(save, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Location>> getAllLocation() {
        List<Location> all = locationRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable long id) {
        try {
            locationRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Location not found...ID doesn't exist", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Location successfully deleted", HttpStatus.OK);
    }

}














