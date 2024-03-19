package com.bigs.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Builder
@ToString
public class WeatherApiRequestDto {

    @NotNull
    @Range(min = 1, max = 100)
    private Integer pageNo;                 // 페이지 번호

    @NotNull
    @Range(min = 1, max = 1000)
    private Integer numOfRows;              // 한 페이지 결과 수

    @NotNull
    @DateTimeFormat(pattern = "yyyyMMdd")
    private String baseDate;                // 발표 일자

    @NotNull
    @DateTimeFormat(pattern = "HHmm")
    private String baseTime;                // 발표 시각

    @NotNull
    @Range(min = 1, max = 200)
    private Integer nx;                     // X 좌표

    @NotNull
    @Range(min = 1, max = 200)
    private Integer ny;                     // Y 좌표
}
