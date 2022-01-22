package com.example.bootcampweekfour.repository.movie;

import com.example.bootcampweekfour.MovieGenre;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity(name = "movie")
@Table(name = "movie")
public class MovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Enumerated(EnumType.STRING)
    private MovieGenre movieGenre;
    private Integer releaseYear;
    @Column(nullable = false)
    private String director;
}
