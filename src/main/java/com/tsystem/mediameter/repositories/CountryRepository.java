package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryModel, Long> {
}