package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.MediaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepository extends JpaRepository<MediaModel, Long> {
}
