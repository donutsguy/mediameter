package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.dtos.MediaDto;
import com.tsystem.mediameter.models.MediaModel;
import com.tsystem.mediameter.repositories.MediaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medias")
public class MediaController {

    @Autowired
    MediaRepository mediaRepository;


    @PostMapping
    public ResponseEntity<MediaModel> createMedia(@RequestBody @Valid MediaDto mediaDto){
        var mediaModel = new MediaModel();
        BeanUtils.copyProperties(mediaDto, mediaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(mediaRepository.save(mediaModel));
    }
}
