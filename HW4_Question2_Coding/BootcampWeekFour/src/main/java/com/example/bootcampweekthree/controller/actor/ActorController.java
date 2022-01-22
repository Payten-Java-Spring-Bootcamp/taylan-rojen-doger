package com.example.bootcampweekthree.controller.actor;

import com.example.bootcampweekthree.controller.actor.request.ActorCreateRequest;
import com.example.bootcampweekthree.controller.actor.response.ActorCreateResponse;
import com.example.bootcampweekthree.service.actor.ActorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ActorController {
    private final ActorService actorService;

    @ApiOperation(value = "Add a actor", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Actor is successfully created")
    })
    @PostMapping("/actors")
    public ActorCreateResponse create(@RequestBody @Valid ActorCreateRequest request) {
        Integer createdActorId = actorService.create(request.convertToActor());
        return ActorCreateResponse.builder().id(createdActorId).build();
    }

}
