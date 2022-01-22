package com.example.bootcampweekthree.controller.rate;

import com.example.bootcampweekthree.controller.rate.request.RateRequest;
import com.example.bootcampweekthree.controller.rate.response.RateResponse;
import com.example.bootcampweekthree.service.rate.Rate;
import com.example.bootcampweekthree.service.rate.RateService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RateController {
    private final RateService rateService;

    @ApiOperation(value = "Add a rate", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Rate is successfully created")
    })
    @PostMapping("/rates")
    public void rate(@RequestBody @Valid RateRequest rateRequest) {
        Rate rate = rateRequest.convertToRate();
        rateService.rateToMovie(rate);
    }

    @ApiOperation(value = "Get rate", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Rate is successfully retrieved")
    })
    @GetMapping("/rate/{movieId}")
    public List<RateResponse> retrieveByMovieId(@PathVariable Integer movieId) {
        List<Rate> rateList = rateService.retrieveByMovieId(movieId);
        return RateResponse.convertFromRate(rateList);
    }
}
