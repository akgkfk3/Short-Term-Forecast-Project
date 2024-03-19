package com.bigs.dto;

import com.bigs.domain.Weather;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class WeatherDto {
    private String baseDate;                // 발표 일자

    private String baseTime;                // 발표 시각

    private String category;                // 자료구분 문자

    private String fcstDate;                // 예보 일자

    private String fcstTime;                // 예보 시각

    private String fcstValue;               // 예보 값

    private Integer nx;                     // X 좌표

    private Integer ny;                     // Y 좌표

    public WeatherDto(Weather weather) {
        this.baseDate = weather.getBaseDate();
        this.baseTime = weather.getBaseTime();
        this.category = weather.getCategory();
        this.fcstDate = weather.getFcstDate();
        this.fcstTime = weather.getFcstTime();
        this.fcstValue = weather.getFcstValue();
        this.nx = weather.getNx();
        this.ny = weather.getNy();
    }
}
