package com.userManagementSystem.repository;

import com.userManagementSystem.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}