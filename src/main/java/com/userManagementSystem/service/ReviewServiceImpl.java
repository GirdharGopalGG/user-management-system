package com.userManagementSystem.service;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Property;
import com.userManagementSystem.entity.Review;
import com.userManagementSystem.repository.PropertyRepository;
import com.userManagementSystem.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;
    private PropertyRepository propertyRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository, PropertyRepository propertyRepository) {
        this.reviewRepository = reviewRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public Review addReview(Review review, AppUser user, long propertyId) {
        Optional<Property> byId = propertyRepository.findById(propertyId);
        Property property = byId.get();
        review.setProperty(property);
        review.setAppUser(user);

        Review review1 = reviewRepository.fetchUserReview(property,user);
        if(review1!=null){
            return null;
        }

        Review save = reviewRepository.save(review);
        return save;
    }

    @Override
    public void deleteReview(long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public Review updateReview(long propertyId, AppUser user, Review updatedReview) {
        Optional<Property> byId = propertyRepository.findById(propertyId);
        Property property = byId.get();
        Review review = reviewRepository.fetchUserReview(property, user);
        if(review==null)
            return null;
        review.setRating(updatedReview.getRating());
        review.setContent(updatedReview.getContent());
        Review save = reviewRepository.save(review);
        return save;

    }


}
