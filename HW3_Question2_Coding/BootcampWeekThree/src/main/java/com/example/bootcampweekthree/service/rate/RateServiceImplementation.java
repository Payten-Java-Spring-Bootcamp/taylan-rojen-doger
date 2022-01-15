package com.example.bootcampweekthree.service.rate;

import com.example.bootcampweekthree.repository.movie.MovieDao;
import com.example.bootcampweekthree.repository.movie.MovieEntity;
import com.example.bootcampweekthree.repository.rate.RateDao;
import com.example.bootcampweekthree.repository.rate.RateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RateServiceImplementation implements RateService {
    private final RateDao rateDao;
    private final MovieDao movieDao;

    @Override
    public void rateToMovie(Rate rate) {
        MovieEntity movieEntity = movieDao.retrieve(rate.getMovieId());
        RateEntity entity = rate.convertToRateEntity(movieEntity);
        rateDao.rateToMovie(entity);
    }

    @Override
    public List<Rate> retrieveByMovieId(Integer movieId) {
        return rateDao.retrieveByMovieId(movieId)
                .stream()
                .map(Rate::convertFromRateEntity)
                .collect(Collectors.toList());
    }
}
