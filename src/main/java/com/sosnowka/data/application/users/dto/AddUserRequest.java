package com.sosnowka.data.application.users.dto;

import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Value
public class AddUserRequest {
    @NotEmpty
    private final String firstName;
    @NotEmpty
    private final String lastName;
    @Email
    @NotEmpty
    private final String email;
    @NotEmpty
    private final String password;
    private final long age;

}
