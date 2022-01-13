package com.devpedrod.dsmovie.services;

import com.devpedrod.dsmovie.dto.MovieDto;
import com.devpedrod.dsmovie.entities.Movie;
import com.devpedrod.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable) {
        Page<Movie> result = movieRepository.findAll(pageable);
        return result.map(MovieDto::new);
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id) {
        Movie movie = movieRepository.findById(id).get();
        return new MovieDto(movie);
    }
}
