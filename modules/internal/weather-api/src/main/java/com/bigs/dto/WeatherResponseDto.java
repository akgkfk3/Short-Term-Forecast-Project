package com.bigs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class WeatherResponseDto {

    private WeatherResponseHeaderDto header;            // 헤더

    private WeatherResponseBodyDto body;                // 바디
}
