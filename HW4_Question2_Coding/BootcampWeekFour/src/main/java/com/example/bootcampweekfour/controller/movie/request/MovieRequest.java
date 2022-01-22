package com.example.bootcampweekfour.controller.movie.request;

import com.example.bootcampweekfour.MovieGenre;
import com.example.bootcampweekfour.service.movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MovieRequest {
    @NotBlank
    private String name;
    @NotNull
    private MovieGenre movieGenre;
    @NotNull
    private Integer releaseYear;
    @NotNull
    private String director;

    public Movie convertMovie() {
        return Movie.builder()
                .name(name)
                .movieGenre(movieGenre)
                .releaseYear(releaseYear)
                .director(director)
                .build();
    }
}
