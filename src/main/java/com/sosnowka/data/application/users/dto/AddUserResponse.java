package com.sosnowka.data.application.users.dto;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AddUserResponse {
    private final String id;

    public static AddUserResponse of(String id) {
        return new AddUserResponse(id);
    }
}
