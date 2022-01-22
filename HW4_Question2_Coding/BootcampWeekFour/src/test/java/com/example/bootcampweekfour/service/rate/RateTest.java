package com.example.bootcampweekfour.service.rate;

import com.example.bootcampweekfour.BootcampWeekFourApplicationTests;
import com.example.bootcampweekfour.MovieGenre;
import com.example.bootcampweekfour.repository.movie.MovieEntity;
import com.example.bootcampweekfour.repository.rate.RateEntity;
import org.junit.jupiter.api.Test;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;

class RateTest extends BootcampWeekFourApplicationTests {

    @Test
    void should_convert_rate_entity_to_rate() {
        //given
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName("LOTR");
        movieEntity.setMovieGenre(MovieGenre.FANTASTIC);
        movieEntity.setDirector("Peter Jackson");
        movieEntity.setReleaseYear(2003);
        RateEntity rateEntity = new RateEntity();
        rateEntity.setMemberId(1);
        rateEntity.setCreatedDate(now());
        rateEntity.setPoint(8);
        rateEntity.setId(1);
        rateEntity.setMovie(movieEntity);
        //when
        Rate rate = Rate.convertFromRateEntity(rateEntity);
        //then
        assertThat(rate).isNotNull();
    }
}