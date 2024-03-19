package com.bigs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class WeatherResponseHeaderDto {

    private String resultCode;              // 응답 메시지 코드

    private String resultMsg;               // 응답 메시지 내용
}
