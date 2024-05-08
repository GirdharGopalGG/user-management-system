package com.userManagementSystem.service;

import com.userManagementSystem.entity.Country;
import com.userManagementSystem.payload.CountryDto;
import com.userManagementSystem.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public CountryDto addCountry(CountryDto countryDto) {
        Country country = mapToEntity(countryDto);
        Country save = countryRepository.save(country);
        CountryDto dto= mapToDto(save);
        return dto;


    }


    public Country mapToEntity(CountryDto countryDto){
        Country country = new Country();
        country.setCountryName(countryDto.getCountryName());

        return country;
    }

    public CountryDto mapToDto(Country country){

        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setCountryName(country.getCountryName());
        return countryDto;
    }
}
