package com.example.bootcampweekthree.controller.rate.request;
import com.example.bootcampweekthree.service.rate.Rate;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class RateRequest {
    @NotNull
    private Integer memberId;

    @NotNull
    private Integer movieId;

    @Min(1)
    @Max(10)
    @NotNull
    private Integer point;

    public Rate convertToRate() {
        return Rate.builder()
                .memberId(memberId)
                .movieId(movieId)
                .point(point)
                .build();
    }
}
