package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.PlatformModel;
import com.tsystem.mediameter.services.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    @Autowired
    private LookupService lookupService;

    @GetMapping
    public ResponseEntity<List<PlatformModel>> getAllPlatforms() {
        List<PlatformModel> platforms = lookupService.getAllPlatforms();
        return ResponseEntity.ok(platforms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformModel> getPlatformById(@PathVariable String id) {
        Long platformId;
        try {
            platformId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(null);
        }

        PlatformModel platform = lookupService.getPlatformById(platformId);
        return ResponseEntity.ok(platform);
    }
}
