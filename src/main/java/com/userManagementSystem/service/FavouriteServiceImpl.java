package com.userManagementSystem.service;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Favourite;
import com.userManagementSystem.entity.Property;
import com.userManagementSystem.repository.FavouriteRepository;
import com.userManagementSystem.repository.PropertyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    private FavouriteRepository favouriteRepository;
    private PropertyRepository propertyRepository;

    public FavouriteServiceImpl(FavouriteRepository favouriteRepository, PropertyRepository propertyRepository) {
        this.favouriteRepository = favouriteRepository;
        this.propertyRepository = propertyRepository;
    }
    @Override
    public Favourite addFavourite( AppUser user,long propertyId) {
        Optional<Property> byId = propertyRepository.findById(propertyId);
        Property property = byId.get();
        Favourite favourite = new Favourite();
        favourite.setAppUser(user);
        favourite.setIsFavourite(true);
        favourite.setProperty(property);
        Favourite save = favouriteRepository.save(favourite);
        return save;


    }

    @Override
    public List<Favourite> getAllFavourites(AppUser user) {
        List<Favourite> favourites = favouriteRepository.fetchByUsername(user);
        return favourites;
    }
}
