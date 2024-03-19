package com.bigs.api;

import com.bigs.dto.WeatherApiRequestDto;
import com.bigs.dto.WeatherApiResponseDto;
import com.bigs.dto.WeatherItemDto;
import com.bigs.dto.WeatherResponseHeaderDto;
import com.bigs.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.List;

import static com.bigs.constant.RequestParameter.*;
import static com.bigs.constant.RequestURI.SHORT_TERM_API;

@Slf4j
@Component
public class ForecastApi {

    private final RestTemplate template;

    public ForecastApi() {
        this.template = new RestTemplate();

        // %25 인코딩 방지
        DefaultUriBuilderFactory uriBuilderFactory = new DefaultUriBuilderFactory();
        uriBuilderFactory.setEncodingMode(DefaultUriBuilderFactory.EncodingMode.NONE);
        template.setUriTemplateHandler(uriBuilderFactory);
    }

    // Service Key --> 추후, yml 파일에서 주입받는 것으로 변경 예정
    private static final String AUTH_KEY = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";

    /**
     * 단기 예보 조회 API
     *
     * @version 0.1
     * @author 박성수
     * @param weatherApiRequestDto (요청 파라미터 객체)
     * @return WeatherApiResponseDto (응답 파라미터 객체)
     */
    public List<WeatherItemDto> getShortForecast(WeatherApiRequestDto weatherApiRequestDto) {
        // URL 설정
        UriComponents url = setUrlVariables(SHORT_TERM_API, weatherApiRequestDto);

        // GET 요청 (JSON 데이터)
        WeatherApiResponseDto data = template.getForEntity(url.toUriString(), WeatherApiResponseDto.class).getBody();

        // 에러 체크
        checkError(data);

        return data.getResponse().getBody().getItems().getItem();
    }

    /**
     * 단기 예보 조회 API는 GET 방식으로 요청하기 때문에 필요한 파라미터를 URL에 세팅해주는 메소드
     *
     * @version 0.1
     * @author 박성수
     * @param url
     * @param weatherApiRequestDto
     * @return URI
     */
    private UriComponents setUrlVariables(String url, WeatherApiRequestDto weatherApiRequestDto) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(SERVICE_KEY, AUTH_KEY)
                .queryParam(PAGE_NO, weatherApiRequestDto.getPageNo())
                .queryParam(NUM_OF_ROWS, weatherApiRequestDto.getNumOfRows())
                .queryParam(REQUEST_BASE_DATE, weatherApiRequestDto.getBaseDate())
                .queryParam(REQUEST_BASE_TIME, weatherApiRequestDto.getBaseTime())
                .queryParam(NX, weatherApiRequestDto.getNx())
                .queryParam(NY, weatherApiRequestDto.getNy())
                .queryParam(DATA_TYPE, "JSON")
                .build();
    }

    /**
     * 조회 API 예외를 검사하는 메소드이다.
     *
     * @version 0.1
     * @author 박성수
     * @param weatherApiResponseDto
     */
    private void checkError(WeatherApiResponseDto weatherApiResponseDto) {
        WeatherResponseHeaderDto header = weatherApiResponseDto.getResponse().getHeader();

        String resultCode = header.getResultCode();
        String resultMsg = header.getResultMsg();

        switch (resultCode) {
            case "01" -> throw new ApplicationErrorException(resultMsg);    // 서버 애플리케이션 에러인 경우
            case "02" -> throw new DatabaseErrorException(resultMsg);       // 서버 DB 에러인 경우
            case "03" -> throw new NoDataException(resultMsg);              // 조회된 데이터가 없는 경우
            case "30" -> throw new UnRegisteredKeyException(resultMsg);     // 등록되지 않은 인증 키인 경우
            case "31" -> throw new ExpiredAuthKeyException(resultMsg);      // 인증 키가 만료된 경우
        }
    }
}
