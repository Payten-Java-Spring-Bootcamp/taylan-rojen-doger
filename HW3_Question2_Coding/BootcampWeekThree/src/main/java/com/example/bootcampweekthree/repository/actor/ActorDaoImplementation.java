package com.example.bootcampweekthree.repository.actor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActorDaoImplementation implements ActorDao{
    private final ActorJPARepository actorJPARepository;

    @Override
    public Integer create(ActorEntity actorEntity) {
        ActorEntity createdActor = actorJPARepository.save(actorEntity);
        return createdActor.getId();
    }


}
