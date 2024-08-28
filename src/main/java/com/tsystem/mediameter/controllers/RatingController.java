package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.RatingUserModel;
import com.tsystem.mediameter.models.UserMediaModel;
import com.tsystem.mediameter.repositories.RatingUserRepository;
import com.tsystem.mediameter.repositories.UserMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    UserMediaRepository userRepository;

    @Autowired
    RatingUserRepository ratingUserRepository;

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getWatched(@PathVariable(value = "id") Long id){
        Optional<UserMediaModel> watchedO = userRepository.findById(id);
        if (watchedO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Watched not found");
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(ratingUserRepository.findAllByUserMedia(watchedO.get()));
    }
}
