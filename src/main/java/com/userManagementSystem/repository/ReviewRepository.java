package com.userManagementSystem.repository;

import com.userManagementSystem.entity.AppUser;
import com.userManagementSystem.entity.Property;
import com.userManagementSystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r where r.property=:proper and r.appUser=:user")
    Review fetchUserReview(@Param("proper") Property property, @Param("user") AppUser user);

}