package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.FriendModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepository extends JpaRepository<FriendModel, Long> {
}