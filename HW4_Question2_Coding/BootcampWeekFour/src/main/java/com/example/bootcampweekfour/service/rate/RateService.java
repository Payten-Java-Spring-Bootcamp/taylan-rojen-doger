package com.example.bootcampweekfour.service.rate;

import java.util.List;

public interface RateService {
    void rateToMovie(Rate rate);
    List<Rate> retrieveByMovieId(Integer movieId);
}
