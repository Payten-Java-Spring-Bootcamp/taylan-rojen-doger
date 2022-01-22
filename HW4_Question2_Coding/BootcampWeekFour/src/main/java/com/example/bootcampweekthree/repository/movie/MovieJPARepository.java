package com.example.bootcampweekthree.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieJPARepository extends JpaRepository<MovieEntity, Integer> {
}
