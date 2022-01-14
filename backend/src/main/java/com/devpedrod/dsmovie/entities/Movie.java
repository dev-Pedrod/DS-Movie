package com.devpedrod.dsmovie.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "tb_movie")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;
    @OneToMany(mappedBy = "id.movie")
    private Set<Score> scores = new HashSet<>();
}
