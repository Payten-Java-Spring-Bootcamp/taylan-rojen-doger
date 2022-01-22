package com.example.bootcampweekfour.service.movie;

import com.example.bootcampweekfour.MovieGenre;
import com.example.bootcampweekfour.repository.movie.MovieEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Movie {
    private Integer id;
    private String name;
    private MovieGenre movieGenre;
    private Integer releaseYear;
    private String director;

    MovieEntity convertToMovieEntity() {
        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(getName());
        movieEntity.setDirector(getDirector());
        movieEntity.setMovieGenre(getMovieGenre());
        movieEntity.setReleaseYear(getReleaseYear());
        return movieEntity;
    }

    public static Movie convertFrom(MovieEntity entity) {
        return Movie.builder()
                .name(entity.getName())
                .movieGenre(entity.getMovieGenre())
                .releaseYear(entity.getReleaseYear())
                .director(entity.getDirector())
                .build();
    }
}
