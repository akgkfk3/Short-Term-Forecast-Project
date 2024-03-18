package com.bigs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@ToString
public class WeatherItemDto {

    private String baseDate;                // 발표 일자

    private String baseTime;                // 발표 시각

    private String category;                // 자료구분 문자

    private String fcstDate;                // 예보 일자

    private String fcstTime;                // 예보 시각

    private String fcstValue;               // 예보 값

    private Integer nx;                     // X 좌표

    private Integer ny;                     // Y 좌표
}
