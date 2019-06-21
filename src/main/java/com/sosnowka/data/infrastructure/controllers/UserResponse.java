package com.sosnowka.data.infrastructure.controllers;

import lombok.Value;

@Value
public class UserResponse {
    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Long age;
}
