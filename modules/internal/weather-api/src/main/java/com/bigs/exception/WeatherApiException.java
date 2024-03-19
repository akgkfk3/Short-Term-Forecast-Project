package com.bigs.exception;

/**
 * Open API 예외를 공통으로 처리하기 위한 상위 Exception
 */
public class WeatherApiException extends RuntimeException{

    public WeatherApiException() {
        super();
    }

    public WeatherApiException(String message) {
        super(message);
    }

    public WeatherApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public WeatherApiException(Throwable cause) {
        super(cause);
    }

    protected WeatherApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
