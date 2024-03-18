package com.bigs.exception;

/**
 * Open API 에러 코드 01번 - Application Error
 */
public class ApplicationErrorException extends WeatherApiException {

    public ApplicationErrorException() {
        super();
    }

    public ApplicationErrorException(String message) {
        super(message);
    }

    public ApplicationErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationErrorException(Throwable cause) {
        super(cause);
    }

    protected ApplicationErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
