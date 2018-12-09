package com.sosnowka.data.application.playground.dto;

import lombok.Value;

@Value
public class AddPlaygroundCommand {
    private final String name;
    private final String city;
    private final String streetName;
    private final String streetNumber;
    private final Long latitude;
    private final Long longitude;
}
