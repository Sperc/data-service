package com.sosnowka.data.application.user;

import com.sosnowka.data.application.base.BaseEntity;

import javax.persistence.Entity;

@Entity
class AppUser extends BaseEntity {
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String surname;
}
