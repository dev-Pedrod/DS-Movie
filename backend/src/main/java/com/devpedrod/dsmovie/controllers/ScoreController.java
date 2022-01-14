package com.devpedrod.dsmovie.controllers;

import com.devpedrod.dsmovie.dto.MovieDto;
import com.devpedrod.dsmovie.dto.ScoreDto;
import com.devpedrod.dsmovie.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scores")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PutMapping("")
    public ResponseEntity<Void> saveScore(@RequestBody ScoreDto scoreDto){
        return ResponseEntity.ok().build();
    }
}
