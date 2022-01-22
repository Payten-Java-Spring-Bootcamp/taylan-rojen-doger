package com.example.bootcampweekthree.repository.movie;

public interface MovieDao{
     Integer save(MovieEntity movieEntity);
     MovieEntity retrieve(Integer id);
}
