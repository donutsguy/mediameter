package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.exeptions.ResourceNotFoundException;
import com.tsystem.mediameter.models.CountryModel;
import com.tsystem.mediameter.models.GenreModel;
import com.tsystem.mediameter.repositories.CountryRepository;
import com.tsystem.mediameter.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    private CountryModel getCountryById(String id) {
        return countryRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Country not found"));
    }
}
