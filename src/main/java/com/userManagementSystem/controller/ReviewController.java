package com.userManagementSystem.controller;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Review;
import com.userManagementSystem.repository.PropertyRepository;
import com.userManagementSystem.repository.ReviewRepository;
import com.userManagementSystem.service.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;
    private final PropertyRepository propertyRepository;


    public ReviewController(ReviewService reviewService, ReviewRepository reviewRepository, PropertyRepository propertyRepository) {
        this.reviewService = reviewService;
        this.reviewRepository = reviewRepository;
        this.propertyRepository = propertyRepository;
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody Review review,
                                            @AuthenticationPrincipal AppUser user,
                                            @RequestParam long propertyId) {


//        Review review1 = reviewRepository.fetchByUsername(review.getProperty(), review.getAppUser());
        if (reviewService.addReview(review, user, propertyId) == null) {
            return new ResponseEntity<>("You have already reviewed this property", HttpStatus.BAD_REQUEST);
        }
        Review review2 = reviewService.addReview(review, user, propertyId);

        return new ResponseEntity<>("Review added", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview(@PathVariable long id) {
        try {
            reviewService.deleteReview(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Review not found...ID incorrect", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Review Deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<?> updateReview(@AuthenticationPrincipal AppUser user,
                                          @PathVariable long propertyId,
                                          @RequestBody Review updatedReview) {

        if (reviewService.updateReview(propertyId, user, updatedReview) == null) {
            return new ResponseEntity<>("Review not found...Write Review", HttpStatus.BAD_REQUEST);
        }
        Review review = reviewService.updateReview(propertyId, user, updatedReview);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}




