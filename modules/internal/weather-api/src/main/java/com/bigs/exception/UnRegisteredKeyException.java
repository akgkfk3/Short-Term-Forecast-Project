package com.bigs.exception;

/**
 * Open API 에러 코드 30번 - SERVICE_KEY_IS_NOT_REGISTERED_ERROR
 */
public class UnRegisteredKeyException extends WeatherApiException{

    public UnRegisteredKeyException() {
        super();
    }

    public UnRegisteredKeyException(String message) {
        super(message);
    }

    public UnRegisteredKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnRegisteredKeyException(Throwable cause) {
        super(cause);
    }

    protected UnRegisteredKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
