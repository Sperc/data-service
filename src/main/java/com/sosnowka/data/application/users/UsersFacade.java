package com.sosnowka.data.application.users;

import com.sosnowka.data.application.users.dto.AddUserRequest;
import com.sosnowka.data.application.users.dto.AddUserResponse;
import com.sosnowka.data.infrastructure.controllers.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsersFacade {
    private final UserService userService;

    public Mono<AddUserResponse> addUser(AddUserRequest addUserRequest) {
        return Mono.just(userService.addUser(addUserRequest))
                   .map(appUser -> AddUserResponse.of(appUser.getUuid()));
    }

    public UserResponse getUserByUuid(String email) {
        return userService.getUserByEmail(email)
                          .toUserResponse();
    }
}
