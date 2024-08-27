package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.TeamModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamModel, Long> {
}