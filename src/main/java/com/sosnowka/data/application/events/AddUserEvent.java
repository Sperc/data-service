package com.sosnowka.data.application.events;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddUserEvent {
    private String firstName;
    private String lastName;
    private String email;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)

    public AddUserEvent(@JsonProperty("firstName") String firstName,
                        @JsonProperty("lastName") String lastName,
                        @JsonProperty("email") String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
