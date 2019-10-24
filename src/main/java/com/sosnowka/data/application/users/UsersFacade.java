package com.sosnowka.data.application.users;

import com.sosnowka.data.application.events.EventSender;
import com.sosnowka.data.application.events.AddUserEvent;
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
    private final EventSender eventSender;

    public Mono<AddUserResponse> addUser(AddUserRequest addUserRequest) {
        return Mono.just(userService.addUser(addUserRequest))
                   .doOnSuccess(appUser -> eventSender.sendAddUserEvent(new AddUserEvent(appUser.getFirstName(),
                                                                                         appUser.getLastName(),
                                                                                         appUser.getEmail())))
                   .map(appUser -> AddUserResponse.of(appUser.getUuid()));
    }

    public UserResponse getUserByUuid(String email) {
        return userService.getUserByEmail(email)
                          .toUserResponse();
    }
}
