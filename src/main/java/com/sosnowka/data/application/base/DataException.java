package com.sosnowka.data.application.base;

import com.sosnowka.data.infrastructure.ApiErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DataException extends RuntimeException {
    private final ApiErrorCode code;
    private final HttpStatus httpStatus;

    public DataException(ApiErrorCode code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
