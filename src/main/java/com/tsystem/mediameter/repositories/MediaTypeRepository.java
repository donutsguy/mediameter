package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.MediaTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaTypeRepository extends JpaRepository<MediaTypeModel, Long> {
}