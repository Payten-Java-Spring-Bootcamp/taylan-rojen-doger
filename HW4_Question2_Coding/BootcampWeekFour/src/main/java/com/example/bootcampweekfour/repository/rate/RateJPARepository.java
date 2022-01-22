package com.example.bootcampweekfour.repository.rate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RateJPARepository extends JpaRepository<RateEntity, Integer> {
    List<RateEntity> findAllByMovieId(Integer movieId);
}
