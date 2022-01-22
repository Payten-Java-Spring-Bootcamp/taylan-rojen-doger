package com.example.bootcampweekthree.controller.rate.response;
import com.example.bootcampweekthree.service.rate.Rate;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
public class RateResponse {
    private LocalDateTime createdDate;
    private Integer memberId;
    private Integer movieId;
    private Integer point;

    public static List<RateResponse> convertFromRate(List<Rate> rateList) {
        return rateList.stream()
                .map(RateResponse::convertFromRate)
                .collect(Collectors.toList());
    }

    private static RateResponse convertFromRate(Rate rate) {
        return RateResponse.builder()
                .createdDate(rate.getCreatedDate())
                .memberId(rate.getMemberId())
                .movieId(rate.getMovieId())
                .point(rate.getPoint())
                .build();
    }
}
