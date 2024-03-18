package com.bigs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class WeatherResponseBodyDto {

    private String dataType;                            // 데이터 타입 (XML, JSON)

    private WeatherItemsDto items;

    private Integer numOfRows;                          // 페이지 결과 수

    private Integer pageNo;                             // 페이지 번호

    private Integer totalCount;                         // 총 개수
}
