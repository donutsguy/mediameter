package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.*;
import com.tsystem.mediameter.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lookups")
public class LookupController {

    @Autowired
    private LookupService lookupService;

    @GetMapping("/media-types")
    public ResponseEntity<List<MediaTypeModel>> getMediaTypes() {
        return ResponseEntity.ok(lookupService.getAllMediaTypes());
    }

    @GetMapping("/idioms")
    public ResponseEntity<List<IdiomModel>> getIdioms() {
        return ResponseEntity.ok(lookupService.getAllIdioms());
    }

    @GetMapping("/platforms")
    public ResponseEntity<List<PlatformModel>> getPlatforms() {
        return ResponseEntity.ok(lookupService.getAllPlatforms());
    }

    @GetMapping("/genres")
    public ResponseEntity<List<GenreModel>> getGenres() {
        return ResponseEntity.ok(lookupService.getAllGenres());
    }

    @GetMapping("/teams")
    public ResponseEntity<List<TeamModel>> getTeams() {
        return ResponseEntity.ok(lookupService.getAllTeams());
    }
}