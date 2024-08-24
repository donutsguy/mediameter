package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.WatchedModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchedRepository extends JpaRepository<WatchedModel, Long> {
}
