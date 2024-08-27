package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.GenreModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<GenreModel, Long> {
}