package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.PlatformModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<PlatformModel, Long> {
}