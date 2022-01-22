package com.example.bootcampweekthree.service.rate;

import com.example.bootcampweekthree.BootcampWeekThreeApplicationTests;
import com.example.bootcampweekthree.MovieGenre;
import com.example.bootcampweekthree.repository.movie.MovieEntity;
import com.example.bootcampweekthree.repository.rate.RateEntity;
import org.junit.jupiter.api.Test;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateTest extends BootcampWeekThreeApplicationTests {

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