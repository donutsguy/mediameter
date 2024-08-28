package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.RatingUserModel;
import com.tsystem.mediameter.models.UserMediaModel;
import com.tsystem.mediameter.models.WatchedModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingUserRepository extends JpaRepository<RatingUserModel, Long> {
    List<WatchedModel> findAllByUserMedia(UserMediaModel user);
}