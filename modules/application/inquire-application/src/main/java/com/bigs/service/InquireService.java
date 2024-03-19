package com.bigs.service;

import com.bigs.dto.WeatherDto;
import java.util.List;

public interface InquireService {
    List<WeatherDto> getWeatherInfoList();
}
