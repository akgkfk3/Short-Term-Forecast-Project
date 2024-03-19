package com.bigs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private int statusCode;             // 상태 코드
    
    private T context;                  // 데이터

    private String message;             // 메시지
}
