package com.example.bootcampweekthree.service.movie;

import com.example.bootcampweekthree.BootcampWeekThreeApplicationTests;
import com.example.bootcampweekthree.MovieGenre;
import com.example.bootcampweekthree.repository.movie.MovieEntity;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MovieTest extends BootcampWeekThreeApplicationTests {

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