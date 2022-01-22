package com.example.bootcampweekthree.service.actor;
import com.example.bootcampweekthree.repository.actor.ActorDao;
import com.example.bootcampweekthree.repository.actor.ActorEntity;
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
