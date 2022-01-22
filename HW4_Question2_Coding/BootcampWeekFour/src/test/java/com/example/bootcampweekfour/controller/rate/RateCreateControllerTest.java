package com.example.bootcampweekfour.controller.rate;

import com.example.bootcampweekfour.BootcampWeekFourApplicationTests;
import com.example.bootcampweekfour.controller.rate.request.RateRequest;
import com.example.bootcampweekfour.controller.rate.response.RateResponse;
import com.example.bootcampweekfour.repository.rate.RateJPARepository;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

class RateCreateControllerTest extends BootcampWeekFourApplicationTests {

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