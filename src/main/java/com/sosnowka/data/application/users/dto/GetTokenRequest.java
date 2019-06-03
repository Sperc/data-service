package com.sosnowka.data.application.users.dto;

import lombok.Data;

@Data
public class GetTokenRequest {
    private String username;
    private String password;
}
