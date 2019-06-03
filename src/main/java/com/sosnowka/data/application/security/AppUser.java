package com.sosnowka.data.application.security;

import com.sosnowka.data.application.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
class AppUser extends BaseEntity {
    private String login;
    private String password;
}