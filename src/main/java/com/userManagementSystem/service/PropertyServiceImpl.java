package com.userManagementSystem.service;

import com.userManagementSystem.entity.Property;
import com.userManagementSystem.payload.PropertyDto;
import com.userManagementSystem.repository.PropertyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PropertyServiceImpl implements PropertyService {
    private PropertyRepository propertyRepository;

    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Property addProperty( Property property) {
        Property save = propertyRepository.save(property);
        return save;

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
