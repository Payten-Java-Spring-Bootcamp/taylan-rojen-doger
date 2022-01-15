package com.example.bootcampweekthree.repository.movie;

import com.example.bootcampweekthree.repository.actor.ActorJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieDaoImplementation implements MovieDao {

    private final MovieJPARepository movieJPARepository;
    private final ActorJPARepository actorJPARepository;

    @Override
    public Integer save(MovieEntity movieEntity) {
        MovieEntity createdEntity = movieJPARepository.save(movieEntity);
        return createdEntity.getId();
    }

    @Override
    public MovieEntity retrieve(Integer id) {
        Optional<MovieEntity> movieEntityOptional = movieJPARepository.findById(id);

        if (movieEntityOptional.isPresent()) {
            return movieEntityOptional.get();
        } else {
            throw new RuntimeException();
        }
    }
}
