package com.bigs.exception;

/**
 * Open API 에러 코드 31번 - DEADLINE_HAS_EXPIRED_ERROR
 */
public class ExpiredAuthKeyException extends WeatherApiException {

    public ExpiredAuthKeyException() {
        super();
    }

    public ExpiredAuthKeyException(String message) {
        super(message);
    }

    public ExpiredAuthKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExpiredAuthKeyException(Throwable cause) {
        super(cause);
    }

    protected ExpiredAuthKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
