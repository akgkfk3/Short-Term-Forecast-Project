package com.bigs.service;

import com.bigs.domain.Weather;
import com.bigs.dto.WeatherDto;
import com.bigs.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InquireServiceImpl implements InquireService {

    private final WeatherRepository weatherRepository;

    /**
     * DB에 저장되어 있는 단기 예보를 조회하는 서비스이다.
     *
     * @version 0.1
     * @author 박성수
     * @return List<WeatherDto>
     */
    @Override
    public List<WeatherDto> getWeatherInfoList() {
        // DB에 있는 단기 예보 정보 가져오기
        List<Weather> weatherList = weatherRepository.findAll();

        // Entity -> Dto 변환하여 Return
        return weatherList.stream().map(WeatherDto::new).toList();
    }
}
