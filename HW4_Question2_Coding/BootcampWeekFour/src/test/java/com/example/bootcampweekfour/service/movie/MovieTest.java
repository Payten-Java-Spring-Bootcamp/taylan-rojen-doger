package com.example.bootcampweekfour.service.movie;

import com.example.bootcampweekfour.BootcampWeekFourApplicationTests;
import com.example.bootcampweekfour.MovieGenre;
import com.example.bootcampweekfour.repository.movie.MovieEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MovieTest extends BootcampWeekFourApplicationTests {

    @Test
    void should_convert_movieEntity_to_movie() {
        //given
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setMovieGenre(MovieGenre.ACTION);
        movieEntity.setName("Rush");
        movieEntity.setDirector("Ron Howard");
        movieEntity.setReleaseYear(2013);
        //when
        Movie movie = Movie.convertFrom(movieEntity);
        //then
        assertThat(movie).isNotNull();
    }
}