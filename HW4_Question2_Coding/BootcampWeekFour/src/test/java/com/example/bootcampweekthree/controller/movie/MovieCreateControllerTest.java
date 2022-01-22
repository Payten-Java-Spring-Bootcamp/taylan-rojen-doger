package com.example.bootcampweekthree.controller.movie;

import com.example.bootcampweekthree.BootcampWeekThreeApplicationTests;
import com.example.bootcampweekthree.MovieGenre;
import com.example.bootcampweekthree.controller.movie.request.MovieRequest;
import com.example.bootcampweekthree.controller.movie.response.MovieCreateResponse;
import com.example.bootcampweekthree.repository.movie.MovieEntity;
import com.example.bootcampweekthree.repository.movie.MovieJPARepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieCreateControllerTest extends BootcampWeekThreeApplicationTests {

    @Autowired
    MovieJPARepository movieJpaRepository;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_add_a_movie_to_database() {
        //given
        MovieRequest movieRequest = new MovieRequest();
        movieRequest.setName("LOTR");
        movieRequest.setDirector("Peter Jackson");
        movieRequest.setReleaseYear(2001);
        movieRequest.setMovieGenre(MovieGenre.FANTASTIC);
        //when
        ResponseEntity<MovieCreateResponse> responseEntity = testRestTemplate.postForEntity("/movies", movieRequest, MovieCreateResponse.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getId()).isNotNull();

        Optional<MovieEntity> movieEntityOptional = movieJpaRepository.findById(responseEntity.getBody().getId());
        assertThat(movieEntityOptional).isPresent();
        assertThat(movieEntityOptional.get().getName()).isEqualTo("LOTR");
    }
}