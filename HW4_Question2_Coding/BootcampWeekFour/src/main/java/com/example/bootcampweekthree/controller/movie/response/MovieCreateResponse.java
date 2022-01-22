package com.example.bootcampweekthree.controller.movie.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieCreateResponse {
    private Integer id;

    public static MovieCreateResponse convertToMovieResponse(Integer id) {
        return MovieCreateResponse.builder()
                .id(id)
                .build();
    }
}
