package com.example.bootcampweekfour.repository.rate;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RateDaoImplementation implements RateDao{
    private final RateJPARepository rateJPARepository;

    @Override
    public void rateToMovie(RateEntity entity) {
        rateJPARepository.save(entity);
    }

    @Override
    public List<RateEntity> retrieveByMovieId(Integer movieId) {
        return rateJPARepository.findAllByMovieId(movieId);
    }
}
