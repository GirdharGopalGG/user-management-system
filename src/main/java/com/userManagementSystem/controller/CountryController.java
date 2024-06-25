package com.userManagementSystem.controller;

import com.userManagementSystem.entity.Country;
import com.userManagementSystem.payload.CountryDto;
import com.userManagementSystem.repository.CountryRepository;
import com.userManagementSystem.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {

    private final CountryService countryService;
    private final CountryRepository countryRepository;

    public CountryController(CountryService countryService, CountryRepository countryRepository) {
        this.countryService = countryService;
        this.countryRepository = countryRepository;
    }

    @PostMapping("/addCountry")
    public ResponseEntity<CountryDto> addCountry(@RequestBody CountryDto countryDto) {

        CountryDto dto = countryService.addCountry(countryDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable long id) {
        try {
            countryRepository.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Country not found...ID incorrect", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Country Deleted Successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Country>> getAllCountry() {
        List<Country> all = countryRepository.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);

    }


}
