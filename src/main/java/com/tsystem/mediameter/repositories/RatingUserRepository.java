package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.RatingUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingUserRepository extends JpaRepository<RatingUserModel, Long> {
}
