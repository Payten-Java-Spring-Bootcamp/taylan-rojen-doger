package com.example.bootcampweekfour.service.actor;
import com.example.bootcampweekfour.repository.actor.ActorDao;
import com.example.bootcampweekfour.repository.actor.ActorEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorServiceImplementation implements ActorService {
    private final ActorDao actorDao;

    @Override
    public Integer create(Actor actor) {
        ActorEntity entity = actor.convertToActorEntity();
        Integer integer = actorDao.create(entity);
        return integer;
    }
}
