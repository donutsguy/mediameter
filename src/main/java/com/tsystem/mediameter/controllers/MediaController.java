package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.dtos.MediaDto;
import com.tsystem.mediameter.models.MediaModel;
import com.tsystem.mediameter.repositories.MediaRepository;
import com.tsystem.mediameter.services.MediaService;
import com.tsystem.mediameter.services.MediaServiceSpecification;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/medias")
public class MediaController {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaService mediaService;

    @Autowired
    private MediaServiceSpecification mediaServiceSpecification;

    @GetMapping
    public ResponseEntity<List<MediaModel>> getMedia(
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
            @RequestParam (value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size
    ){
        //response de pagina
//        if (page != null && size != null){
//           return ResponseEntity.status(HttpStatus.FOUND).body(mediaService.getAll(page, size));
//        }

        return ResponseEntity.status(HttpStatus.FOUND).body(mediaServiceSpecification.getAllMedias(
                name, description, platform, idiom, country, genre, team, mediaType, userMedia, startDate, endDate
        ));
    }


    @PostMapping
    public ResponseEntity<MediaModel> createMedia(@RequestBody @Valid MediaDto mediaDto){
        var mediaModel = new MediaModel();
        BeanUtils.copyProperties(mediaDto, mediaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mediaRepository.save(mediaModel));
    }
}
