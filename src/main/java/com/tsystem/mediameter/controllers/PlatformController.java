package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.MediaTypeModel;
import com.tsystem.mediameter.models.PlatformModel;
import com.tsystem.mediameter.repositories.MediaTypeRepository;
import com.tsystem.mediameter.repositories.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    @Autowired
    PlatformRepository platformRepository;

    @GetMapping
    public ResponseEntity<List<PlatformModel>> getPlatform(){
        return ResponseEntity.status(HttpStatus.FOUND).body(platformRepository.findAll());
    }
}
