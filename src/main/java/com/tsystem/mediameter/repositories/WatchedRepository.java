package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.UserMediaModel;
import com.tsystem.mediameter.models.WatchedModel;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WatchedRepository extends JpaRepository<WatchedModel, Long> {
    List<WatchedModel> findAllByUser(UserMediaModel user);
}