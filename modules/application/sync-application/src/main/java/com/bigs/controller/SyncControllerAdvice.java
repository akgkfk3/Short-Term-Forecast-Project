package com.bigs.controller;

import com.bigs.dto.ResponseDto;
import com.bigs.exception.ApplicationErrorException;
import com.bigs.exception.DatabaseErrorException;
import com.bigs.exception.ExpiredAuthKeyException;
import com.bigs.exception.UnRegisteredKeyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {SyncController.class})
public class SyncControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ApplicationErrorException.class)
    public ResponseDto<String> applicationErrorException(ApplicationErrorException e) {
        log.error(e.getMessage(), e);

        return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExpiredAuthKeyException.class)
    public ResponseDto<String> expiredAuthKeyException(ExpiredAuthKeyException e) {
        log.error(e.getMessage(), e);

        return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler()
    public ResponseDto<String> unregisteredKeyException(UnRegisteredKeyException e) {
        log.error(e.getMessage(), e);

        return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), null, e.getMessage());
    }
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler()
    public ResponseDto<String> databaseErrorException(DatabaseErrorException e) {
        log.error(e.getMessage(), e);

        return new ResponseDto<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, e.getMessage());
    }
}
