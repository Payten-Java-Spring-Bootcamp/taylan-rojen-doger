package com.example.bootcampweekthree.repository.rate;

import java.util.List;

public interface RateDao {
    void rateToMovie(RateEntity entity);

    List<RateEntity> retrieveByMovieId(Integer movieId);
}
