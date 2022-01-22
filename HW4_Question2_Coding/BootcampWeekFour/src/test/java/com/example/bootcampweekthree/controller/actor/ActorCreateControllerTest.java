package com.example.bootcampweekthree.controller.actor;

import com.example.bootcampweekthree.BootcampWeekThreeApplicationTests;
import com.example.bootcampweekthree.controller.actor.request.ActorCreateRequest;
import com.example.bootcampweekthree.controller.actor.response.ActorCreateResponse;
import com.example.bootcampweekthree.repository.actor.ActorJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import static java.time.LocalDateTime.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ActorCreateControllerTest extends BootcampWeekThreeApplicationTests {

    @Autowired
    ActorJPARepository actorJPARepository;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_create_actor() {
        //given
        ActorCreateRequest actorCreateRequest = new ActorCreateRequest();
        actorCreateRequest.setName("Orlando Bloom");
        actorCreateRequest.setBirthDate(now());
        //when
        ResponseEntity<ActorCreateResponse> actorCreateResponseEntity = testRestTemplate.postForEntity("/actors", actorCreateRequest, ActorCreateResponse.class);
        //then
        assertThat(actorCreateResponseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(actorCreateResponseEntity.getBody().getId()).isNotNull();
    }
}