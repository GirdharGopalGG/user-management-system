package com.userManagementSystem.service;

import com.userManagementSystem.entity.Location;
import com.userManagementSystem.payload.LocationDto;
import com.userManagementSystem.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {
    private LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public LocationDto addLocation(LocationDto locationDto) {
        Location location = mapToEntity(locationDto);
        Location save = locationRepository.save(location);
        LocationDto locationDto1 = mapToDto(save);
        return locationDto1;

    }

    private Location mapToEntity(LocationDto locationDto) {
        Location location = new Location();
        location.setLocationName(locationDto.getLocationName());
        location.setId(locationDto.getId());
        return location;
    }

    LocationDto mapToDto(Location location){
        LocationDto locationDto = new LocationDto();
        locationDto.setId(location.getId());
        locationDto.setLocationName(location.getLocationName());
        return locationDto;
    }
}
