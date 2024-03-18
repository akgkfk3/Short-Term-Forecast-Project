package com.bigs.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter @Builder
@ToString
public class WeatherApiRequestDto {
    private Integer pageNo;                 // 페이지 번호

    private Integer numOfRows;              // 한 페이지 결과 수

    private String baseDate;                // 발표 일자

    private String baseTime;                // 발표 시각

    private Integer nx;                     // X 좌표

    private Integer ny;                     // Y 좌표
}
