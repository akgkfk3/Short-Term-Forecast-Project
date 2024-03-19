package com.bigs.service;

import com.bigs.dto.WeatherApiRequestDto;

public interface SyncService {

    void sync(WeatherApiRequestDto weatherApiRequestDto);
}
