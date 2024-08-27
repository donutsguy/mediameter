package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.CountryModel;
import com.tsystem.mediameter.models.MediaTypeModel;
import com.tsystem.mediameter.repositories.CountryRepository;
import com.tsystem.mediameter.repositories.MediaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mediastypes")
public class MediaTypeController {

    @Autowired
    MediaTypeRepository mediaTypeRepository;

    @GetMapping
    public ResponseEntity<List<MediaTypeModel>> getMediaType(){
        return ResponseEntity.status(HttpStatus.FOUND).body(mediaTypeRepository.findAll());
    }
}
