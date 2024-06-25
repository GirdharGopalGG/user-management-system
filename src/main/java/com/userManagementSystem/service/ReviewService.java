package com.userManagementSystem.service;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Review;


public interface ReviewService {
    Review addReview( Review review, AppUser user, long propertyId);

    void deleteReview( long id);

    Review updateReview(long propertyId, AppUser user, Review updatedReview);
}


