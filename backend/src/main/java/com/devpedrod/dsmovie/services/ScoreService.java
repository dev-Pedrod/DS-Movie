package com.devpedrod.dsmovie.services;

import com.devpedrod.dsmovie.dto.MovieDto;
import com.devpedrod.dsmovie.dto.ScoreDto;
import com.devpedrod.dsmovie.entities.Movie;
import com.devpedrod.dsmovie.entities.Score;
import com.devpedrod.dsmovie.entities.User;
import com.devpedrod.dsmovie.repositories.MovieRepository;
import com.devpedrod.dsmovie.repositories.ScoreRepository;
import com.devpedrod.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public void saveScore(ScoreDto scoreDto){
        if(userRepository.findByEmail(scoreDto.getEmail()) == null) {
            userRepository.saveAndFlush(new User(null,scoreDto.getEmail()));
        }

        Movie movie = movieRepository.findById(scoreDto.getMovieId()).get();
        Score score = new Score();
        score.setMovie(movie);
        score.setUser(userRepository.findByEmail(scoreDto.getEmail()));
        score.setValue(scoreDto.getScore());
        scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()) {
            sum += s.getValue();
        }
        Double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movieRepository.save(movie);
    }

}
