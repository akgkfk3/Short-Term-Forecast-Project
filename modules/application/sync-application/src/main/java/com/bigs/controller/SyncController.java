package com.bigs.controller;

import com.bigs.dto.ResponseDto;
import com.bigs.dto.WeatherApiRequestDto;
import com.bigs.service.SyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SyncController {

    private final SyncService syncService;

    /**
     * 단기 예보 API를 호출하여 응답받은 데이터를 DB에 저장하는 컨트롤러
     *
     * @version 0.1
     * @author 박성수
     * @param weatherApiRequestDto 객체
     * @return ResponseEntity<ResponseDto<String>>
     */
    @PostMapping("/sync")
    public ResponseEntity<ResponseDto<String>> syncWeatherData(@ModelAttribute WeatherApiRequestDto weatherApiRequestDto) {
        // 데이터 동기화
        syncService.sync(weatherApiRequestDto);

        ResponseDto<String> responseDto =
                new ResponseDto<>(HttpStatus.OK.value(), null, "데이터 Sync 성공");

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
