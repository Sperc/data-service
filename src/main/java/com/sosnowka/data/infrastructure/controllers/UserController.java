package com.sosnowka.data.infrastructure.controllers;

import com.sosnowka.data.application.base.DataException;
import com.sosnowka.data.infrastructure.ApiErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/users")
    public String test() {
        throw new DataException(ApiErrorCode.VALIDATION_ERROR, "error message", HttpStatus.BAD_REQUEST);
    }

}
