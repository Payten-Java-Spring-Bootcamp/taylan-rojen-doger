package com.example.bootcampspringsecondproject;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Builder
public class Movie {
    private String movieName;
    private Genre genre;
    private Integer releaseYear;
    private String director;
    private List<String> actorList;
}
