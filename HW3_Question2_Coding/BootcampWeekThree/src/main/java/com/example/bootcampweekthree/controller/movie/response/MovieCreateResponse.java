package com.example.bootcampweekthree.controller.movie.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MovieCreateResponse {
    private Integer id;

    public static MovieCreateResponse convertToMovieResponse(Integer id) {
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
