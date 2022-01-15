package com.example.bootcampweekthree.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieJPARepository extends JpaRepository<MovieEntity, Integer> {
}
