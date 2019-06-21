package com.sosnowka.data.application.users.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = "password")
public class GetTokenRequest {
    private String username;
    private String password;
}
