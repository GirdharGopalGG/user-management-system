package com.userManagementSystem.controller;

import com.userManagementSystem.payload.CountryDto;
import com.userManagementSystem.repository.CountryRepository;
import com.userManagementSystem.service.CountryService;
import com.userManagementSystem.service.CountryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private CountryService countryService;
   public CountryController(CountryService countryService){
        this.countryService = countryService;
    }

    @PostMapping("/addCountry")
    public ResponseEntity<CountryDto> addCountry(@RequestBody CountryDto countryDto){

        CountryDto dto = countryService.addCountry(countryDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }









}
