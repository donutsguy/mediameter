package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.GenreModel;
import com.tsystem.mediameter.models.IdiomModel;
import com.tsystem.mediameter.repositories.GenreRepository;
import com.tsystem.mediameter.repositories.IdiomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genres")
public class GenreController {

    @Autowired
    GenreRepository genreRepository;

    @GetMapping
    public ResponseEntity<List<GenreModel>> getGenre(){
        return ResponseEntity.status(HttpStatus.FOUND).body(genreRepository.findAll());
    }
}
