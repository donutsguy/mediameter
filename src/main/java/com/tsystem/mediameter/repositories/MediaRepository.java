package com.tsystem.mediameter.repositories;

import com.tsystem.mediameter.models.MediaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface MediaRepository extends JpaRepository<MediaModel, Long>, JpaSpecificationExecutor<MediaModel> {
    List<MediaModel> findByName(String name);
    List<MediaModel> findByDescription(String description);
    List<MediaModel> findByReleaseDateBetween(LocalDate startDate, LocalDate endDate);
    List<MediaModel> findByPlatformName(String platformName);
    List<MediaModel> findByIdiomName(String idiomName);
    List<MediaModel> findByCountryName(String countryName);
    List<MediaModel> findByGenreName(String genreName);
    List<MediaModel> findByTeamName(String teamName);
    List<MediaModel> findByMediaTypeName(String mediaTypeName);
    List<MediaModel> findByUserMediaName(String userMediaName);
    Page<MediaModel> findAll(Specification<MediaModel> spec, Pageable pageable);
}
