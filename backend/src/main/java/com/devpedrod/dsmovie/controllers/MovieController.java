package com.devpedrod.dsmovie.controllers;

import com.devpedrod.dsmovie.dto.MovieDto;
import com.devpedrod.dsmovie.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<MovieDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(movieService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findById(id));
    }
}
