package com.example.bootcampweekfour.controller.movie.response;

import com.example.bootcampweekfour.MovieGenre;
import com.example.bootcampweekfour.service.movie.Movie;
import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class MovieResponse {
    private String name;
    private MovieGenre movieGenre;
    private Integer releaseYear;
    private String director;
    private List<CastResponse> castList;

    public static MovieResponse convertFrom(Movie movie) {
        return MovieResponse.builder()
                .name(movie.getName())
                .movieGenre(movie.getMovieGenre())
                .releaseYear(movie.getReleaseYear())
                .director(movie.getDirector())
                .build();
    }

}
