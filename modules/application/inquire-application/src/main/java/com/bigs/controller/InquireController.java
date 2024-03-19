package com.bigs.controller;

import com.bigs.dto.ResponseDto;
import com.bigs.dto.WeatherDto;
import com.bigs.service.InquireService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class InquireController {

    private final InquireService inquireService;

    /**
     * DB에 저장되어 있는 단기 예보를 조회하는 컨트롤러이다.
     *
     * @version 0.1
     * @author 박성수
     * @return ResponseEntity<ResponseDto<List<WeatherDto>>>
     */
    @GetMapping("/weather")
    @ResponseBody
    public ResponseEntity<ResponseDto<List<WeatherDto>>> getWeatherInfo() {

        // 단기 예보 정보 가져오기
        List<WeatherDto> weatherInfoList = inquireService.getWeatherInfoList();

        // 데이터가 없는 경우, 204 응답
        if (weatherInfoList.isEmpty()) {
            ResponseDto<List<WeatherDto>> responseDto =
                    new ResponseDto<>(HttpStatus.NO_CONTENT.value(), null, "No Data");

            return new ResponseEntity<>(responseDto, HttpStatus.NO_CONTENT);
        }

        // 데이터가 있으면 200 응답
        ResponseDto<List<WeatherDto>> responseDto =
                new ResponseDto<>(HttpStatus.OK.value(), weatherInfoList, null);

        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
