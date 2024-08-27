package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.RatingModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<RatingModel, Long> {
}