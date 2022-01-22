package com.example.bootcampweekthree.controller.rate;

import com.example.bootcampweekthree.BootcampWeekThreeApplicationTests;
import com.example.bootcampweekthree.controller.rate.request.RateRequest;
import com.example.bootcampweekthree.controller.rate.response.RateResponse;
import com.example.bootcampweekthree.repository.rate.RateJPARepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

class RateCreateControllerTest extends BootcampWeekThreeApplicationTests {

    @Autowired
    RateJPARepository rateJPARepository;

    @Test
    @Sql(scripts = "/cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void should_give_point_to_a_movie() {
        //given
        RateRequest rateRequest = new RateRequest();
        rateRequest.setMemberId(1);
        rateRequest.setMovieId(1);
        rateRequest.setPoint(5);
        //when
        ResponseEntity<RateResponse> rateResponseEntity = testRestTemplate.postForEntity("/rates", rateRequest, RateResponse.class);
        //then
        assertThat(rateResponseEntity.getBody()).isNotNull();
    }
}