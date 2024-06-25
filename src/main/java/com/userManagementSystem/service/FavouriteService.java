package com.userManagementSystem.service;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Favourite;

import java.util.List;

public interface FavouriteService {
    Favourite addFavourite( AppUser user,long propertyId);

    List<Favourite> getAllFavourites(AppUser user);
}
