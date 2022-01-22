package com.example.bootcampweekfour.repository.movie;

public interface MovieDao{
     Integer save(MovieEntity movieEntity);
     MovieEntity retrieve(Integer id);
}
