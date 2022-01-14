package com.devpedrod.dsmovie.repositories;

import com.devpedrod.dsmovie.entities.Score;
import com.devpedrod.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {

}
