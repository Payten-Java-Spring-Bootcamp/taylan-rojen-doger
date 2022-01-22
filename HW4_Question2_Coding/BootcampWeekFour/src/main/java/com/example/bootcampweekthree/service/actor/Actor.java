package com.example.bootcampweekthree.service.actor;
import com.example.bootcampweekthree.repository.actor.ActorEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Actor {
    private Integer id;
    private String name;
    private LocalDateTime birthDate;

    public ActorEntity convertToActorEntity() {
        ActorEntity entity = new ActorEntity();
        entity.setName(name);
        entity.setBirthDate(birthDate);
        return entity;
    }
}
