package com.bigs.exception;

/**
 * Open API 에러 코드 02번 - DB_ERROR
 */
public class DatabaseErrorException extends WeatherApiException{

    public DatabaseErrorException() {
        super();
    }

    public DatabaseErrorException(String message) {
        super(message);
    }

    public DatabaseErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseErrorException(Throwable cause) {
        super(cause);
    }

    protected DatabaseErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
