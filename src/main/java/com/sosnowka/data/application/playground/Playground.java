package com.sosnowka.data.application.playground;

import com.sosnowka.data.application.base.BaseEntity;
import com.sosnowka.data.application.playground.dto.AddPlaygroundCommand;
import lombok.Getter;

import javax.persistence.Entity;

@Entity
@Getter
class Playground extends BaseEntity {
    private String name;
    private String city;
    private String streetName;
    private String streetNumber;
    private Long latitude;
    private Long longitude;

    Playground updatePlayground(AddPlaygroundCommand addPlaygroundCommand) {
        this.name = addPlaygroundCommand.getName();
        this.city = addPlaygroundCommand.getCity();
        this.latitude = addPlaygroundCommand.getLatitude();
        this.longitude = addPlaygroundCommand.getLongitude();
        this.streetName = addPlaygroundCommand.getStreetName();
        this.streetNumber = addPlaygroundCommand.getStreetNumber();
        return this;
    }
}
