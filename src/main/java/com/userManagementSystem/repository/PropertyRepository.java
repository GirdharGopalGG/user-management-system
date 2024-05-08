package com.userManagementSystem.repository;

import com.userManagementSystem.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long> {
}