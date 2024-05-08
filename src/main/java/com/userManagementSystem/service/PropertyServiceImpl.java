package com.userManagementSystem.service;

import com.userManagementSystem.entity.Property;
import com.userManagementSystem.payload.PropertyDto;
import com.userManagementSystem.repository.PropertyRepository;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public PropertyDto addProperty(PropertyDto propertyDto) {
        Property property = mapToEntity(propertyDto);
        Property save = propertyRepository.save(property);
        PropertyDto propertyDto1 = mapToDto(save);
        return propertyDto1;

    }

    private Property mapToEntity(PropertyDto propertyDto) {
        Property property = new Property();
        property.setId(propertyDto.getId());
        property.setPropertyName(propertyDto.getPropertyName());
        property.setBeds(propertyDto.getBeds());
        property.setBedrooms(propertyDto.getBedrooms());
        property.setBathrooms(propertyDto.getBathrooms());
        property.setGuests(propertyDto.getGuests());
        property.setNightlyPrice(propertyDto.getNightlyPrice());
        return property;
    }
    public PropertyDto mapToDto(Property property){
        PropertyDto propertyDto= new PropertyDto();
        propertyDto.setId(property.getId());
        propertyDto.setBathrooms(property.getBathrooms());
        propertyDto.setPropertyName(property.getPropertyName());
        propertyDto.setBeds(property.getBeds());
        propertyDto.setGuests(property.getGuests());
        propertyDto.setNightlyPrice(property.getNightlyPrice());
        propertyDto.setBedrooms(property.getBedrooms());
        return propertyDto;
    }
}
