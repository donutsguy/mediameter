package com.tsystem.mediameter.controllers;

import com.tsystem.mediameter.models.PlatformModel;
import com.tsystem.mediameter.models.TeamModel;
import com.tsystem.mediameter.repositories.PlatformRepository;
import com.tsystem.mediameter.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping
    public ResponseEntity<List<TeamModel>> getTeam(){
        return ResponseEntity.status(HttpStatus.FOUND).body(teamRepository.findAll());
    }
}
