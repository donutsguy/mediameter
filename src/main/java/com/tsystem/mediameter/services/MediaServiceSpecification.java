package com.tsystem.mediameter.services;

import com.tsystem.mediameter.models.MediaModel;
import com.tsystem.mediameter.repositories.MediaRepository;
import com.tsystem.mediameter.specifications.MediaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MediaServiceSpecification {

    @Autowired
    private MediaRepository mediaRepository;

    public Page<MediaModel> getAllPageablesMedias(String name, String description, String platform,
                                                  String idiom, String country, String genre, String team,
                                                  String type, String userMedia, LocalDate startDate, LocalDate endDate,
                                                  Integer page, Integer size, List<Sort.Order> orders){

        Specification<MediaModel> spec = Specification
                .where(MediaSpecification.containsName(name))
                .and(MediaSpecification.containsDescription(description))
                .and(MediaSpecification.hasPlatform(platform))
                .and(MediaSpecification.hasIdiom(idiom))
                .and(MediaSpecification.hasCountry(country))
                .and(MediaSpecification.hasGenre(genre))
                .and(MediaSpecification.hasTeam(team))
                .and(MediaSpecification.hasMediaType(type))
                .and(MediaSpecification.hasUserMedia(userMedia))
                .and(MediaSpecification.hasReleaseDateRange(startDate, endDate));

        PageRequest pageable = PageRequest.of(page, size, Sort.by(orders));

        return mediaRepository.findAll(spec, pageable);
    }
}
