package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.UserMediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserMediaModel, Long> {
}
