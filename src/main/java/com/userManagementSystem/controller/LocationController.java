package com.userManagementSystem.controller;

import com.userManagementSystem.payload.LocationDto;
import com.userManagementSystem.service.LocationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/location")
public class LocationController {

    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("/addLocation")
    public ResponseEntity<LocationDto> addLocation(@RequestBody LocationDto locationDto){
        LocationDto locationDto1 = locationService.addLocation(locationDto);
        return new ResponseEntity<>(locationDto1, HttpStatus.CREATED);
    }
}














