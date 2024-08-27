package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.IdiomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdiomRepository extends JpaRepository<IdiomModel, Long> {
}