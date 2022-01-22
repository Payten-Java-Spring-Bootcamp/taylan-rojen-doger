package com.example.bootcampweekfour.controller.actor.request;

import com.example.bootcampweekfour.service.actor.Actor;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
public class ActorCreateRequest {
    @NotBlank
    private String name;
    @NotNull
    private LocalDateTime birthDate;

    public Actor convertToActor() {
        return Actor.builder()
                .name(name)
                .birthDate(birthDate)
                .build();
    }
}
