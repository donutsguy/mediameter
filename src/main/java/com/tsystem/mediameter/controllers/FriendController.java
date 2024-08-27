package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.FriendModel;
import com.tsystem.mediameter.models.GenreModel;
import com.tsystem.mediameter.repositories.FriendRepository;
import com.tsystem.mediameter.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @GetMapping
    public ResponseEntity<List<FriendModel>> getFriend(){
        return ResponseEntity.status(HttpStatus.FOUND).body(friendRepository.findAll());
    }
}
