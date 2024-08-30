package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.TeamModel;
import com.tsystem.mediameter.models.UserMediaModel;
import com.tsystem.mediameter.models.WatchedModel;
import com.tsystem.mediameter.repositories.TeamRepository;
import com.tsystem.mediameter.repositories.UserMediaRepository;
import com.tsystem.mediameter.repositories.WatchedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/watcheds")
public class WatchedController {

    @Autowired
    WatchedRepository watchedRepository;

    @Autowired
    UserMediaRepository userRepository;

    @GetMapping()
    public ResponseEntity<List<WatchedModel>> getAllWatched(){
        return ResponseEntity.status(HttpStatus.FOUND).body(watchedRepository.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getWatched(@PathVariable(value = "id") Long id){
        Optional<UserMediaModel> watchedO = userRepository.findById(id);
        if (watchedO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Watched not found");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(watchedRepository.findAllByUser(watchedO.get()));
    }
}
