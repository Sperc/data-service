package com.sosnowka.data.application.users;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserContext {
    private String uuid;
    private UserName userName;
    private String email;
    private Long age;

    @Value
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class UserName {
        private String firstName;
        private String lastName;

        static UserName of(String firstName, String lastName) {
            return new UserName(firstName, lastName);
        }
    }

}
