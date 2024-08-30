package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.*;
import com.tsystem.mediameter.repositories.MediaRepository;
import com.tsystem.mediameter.services.LookupService;
import com.tsystem.mediameter.services.MediaServiceSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.tsystem.mediameter.dtos.MediaDto;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/medias")
public class MediaController {
    private static final Set<String> ALLOWED_SORT_FIELDS = Set.of("name", "platform", "idiom", "country", "genre", "team", "media_type");

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaServiceSpecification mediaServiceSpecification;

    @Autowired
    private LookupService lookupService;

    @GetMapping("/{id}")
    public ResponseEntity<MediaModel> getMediaById(@PathVariable Long id) {
        Optional<MediaModel> media = mediaRepository.findById(id);
        if (media.isPresent()) {
            return ResponseEntity.ok(media.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<Page<MediaModel>> getMedia(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "platform", required = false) String platform,
            @RequestParam(value = "idiom", required = false) String idiom,
            @RequestParam(value = "country", required = false) String country,
            @RequestParam(value = "genre", required = false) String genre,
            @RequestParam(value = "team", required = false) String team,
            @RequestParam(value = "type", required = false) String mediaType,
            @RequestParam(value = "user", required = false) String userMedia,
            @RequestParam(value = "startdate", required = false) LocalDate startDate,
            @RequestParam(value = "enddate", required = false) LocalDate endDate,
            @RequestParam (value = "page", defaultValue = "0") Integer page,
            @RequestParam (value = "size", defaultValue = "5") Integer size,
            @RequestParam(required = false) String[] sort
    ) {
        List<Sort.Order> orders = new ArrayList<>();

        if (sort != null) {
            for (int i = 0; i < sort.length / 2; i++) {
                String field = sort[i];
                String direction = sort[i + 1];
                if (ALLOWED_SORT_FIELDS.contains(field)) {
                    Sort.Direction sortDirection = direction.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
                    orders.add(new Sort.Order(sortDirection, field));
                }
            }
        }

        if (orders.isEmpty()) {
            orders.add(Sort.Order.asc("name"));
        }

        Page<MediaModel> mediaPage = mediaServiceSpecification.getAllPageablesMedias(
                name, description, platform, idiom, country, genre, team, mediaType, userMedia, startDate, endDate,
                page, size, orders
        );

        return ResponseEntity.ok(mediaPage);
    }

    @PostMapping
    public ResponseEntity<MediaModel> createMedia(
            @RequestParam("mediaTypeId") Long mediaTypeId,
            @RequestParam("idiomId") Long idiomId,
            @RequestParam("name") String name,
            @RequestParam("genreId") Long genreId,
            @RequestParam("releaseDate") String releaseDate,
            @RequestParam("platformId") Long platformId,
            @RequestParam("photo") MultipartFile photo,
            @RequestParam("description") String description,
            @RequestParam("userMediaId") Long userMediaId,
            @RequestParam("countryId") Long countryId,
            @RequestParam("teamId") Long teamId) {

        MediaModel mediaModel = new MediaModel();
        mediaModel.setPlatform(lookupService.getPlatformById(platformId));
        mediaModel.setIdiom(lookupService.getIdiomById(idiomId));
        mediaModel.setCountry(lookupService.getCountryById(countryId));
        mediaModel.setGenre(lookupService.getGenreById(genreId));
        mediaModel.setTeam(lookupService.getTeamById(teamId));
        mediaModel.setMediaType(lookupService.getMediaTypeById(mediaTypeId));
        mediaModel.setUserMedia(lookupService.getUserMediaById(userMediaId));
        mediaModel.setName(name);
        mediaModel.setDescription(description);
        mediaModel.setReleaseDate(LocalDate.parse(releaseDate));

        MediaModel savedMedia = mediaRepository.save(mediaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMedia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMedia(@PathVariable(value = "id") Long id, @RequestBody @Valid MediaDto mediaDto) {
        Optional<MediaModel> mediaO = mediaRepository.findById(id);
        if (mediaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Media not found");
        }

        var mediaModel = mediaO.get();
        BeanUtils.copyProperties(mediaDto, mediaModel);
        return ResponseEntity.status(HttpStatus.OK).body(mediaRepository.save(mediaModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMedia(@PathVariable(value = "id") Long id) {
        Optional<MediaModel> mediaO = mediaRepository.findById(id);
        if (mediaO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Media not found");
        }

        mediaRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully media excluded");
    }
}
