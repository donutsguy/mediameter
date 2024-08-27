package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.UserMediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMediaRepository extends JpaRepository<UserMediaModel, Long> {
}