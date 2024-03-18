package com.bigs.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor @Builder
public class Weather extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private Long id;

    @Column
    private String baseDate;                // 발표 일자

    @Column
    private String baseTime;                // 발표 시각

    @Column
    private String category;                // 자료구분 문자

    @Column
    private String fcstDate;                // 예보 일자

    @Column
    private String fcstTime;                // 예보 시각

    @Column
    private String fcstValue;               // 예보 값

    @Column
    private Integer nx;                     // X 좌표

    @Column
    private Integer ny;                     // Y 좌표
}
