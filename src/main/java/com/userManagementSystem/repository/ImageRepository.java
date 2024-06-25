package com.userManagementSystem.repository;

import com.userManagementSystem.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}