package com.bigs.service;

import com.bigs.api.ForecastApi;
import com.bigs.domain.Weather;
import com.bigs.dto.WeatherApiRequestDto;
import com.bigs.dto.WeatherItemDto;
import com.bigs.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SyncServiceImpl implements SyncService {
    
    private final ForecastApi forecastApi;

    private final WeatherRepository weatherRepository;

    /**
     * 단기 예보 API를 호출하여 응답받은 데이터를 DB에 저장하는 서비스이다.
     *
     * @version 0.1
     * @author 박성수
     * @param weatherApiRequestDto
     */
    @Override
    @Transactional
    public void sync(WeatherApiRequestDto weatherApiRequestDto) {

        // 단기 예보 조회 API 호출
        List<WeatherItemDto> shortForecast = forecastApi.getShortForecast(weatherApiRequestDto);

        // 기존 데이터 삭제
        weatherRepository.deleteAll();

        // DB에 저장
        shortForecast.forEach(weatherItemDto -> {
            Weather weather = Weather.builder()
                    .baseDate(weatherItemDto.getBaseDate())
                    .baseTime(weatherItemDto.getBaseTime())
                    .category(weatherItemDto.getCategory())
                    .fcstDate(weatherItemDto.getFcstDate())
                    .fcstTime(weatherItemDto.getFcstTime())
                    .fcstValue(weatherItemDto.getFcstValue())
                    .nx(weatherItemDto.getNx())
                    .ny(weatherItemDto.getNy())
                    .build();

            weatherRepository.save(weather);
        });
    }
}
