package com.example.bootcampweekfour.repository.rate;
import com.example.bootcampweekfour.repository.movie.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "rate")
@Table(name = "rate")
public class RateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @Column(nullable = false)
    private Integer memberId;

    @Column(nullable = false)
    private Integer point;

    @ManyToOne
    @JoinColumn(nullable = false)
    private MovieEntity movie;
}
