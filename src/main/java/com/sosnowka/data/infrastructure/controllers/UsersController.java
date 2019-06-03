package com.sosnowka.data.infrastructure.controllers;

import com.sosnowka.data.application.users.SessionUtil;
import com.sosnowka.data.application.users.UsersFacade;
import com.sosnowka.data.application.users.dto.AddUserRequest;
import com.sosnowka.data.application.users.dto.AddUserResponse;
import com.sosnowka.data.application.users.dto.GetTokenRequest;
import com.sosnowka.data.application.users.dto.TokenResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersFacade usersFacade;
    private final SessionUtil sessionUtil;

    @PostMapping
    public Mono<AddUserResponse> addUser(@Valid @RequestBody AddUserRequest addUserRequest) {
        log.info("Add user request: {}", addUserRequest);
        return usersFacade.addUser(addUserRequest);
    }

    @PostMapping("/token")
    public TokenResponse getToken(GetTokenRequest request) {
        log.info("Get token request: {}", request);
        return sessionUtil.generateToken(request);
    }
}
