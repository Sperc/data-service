package com.sosnowka.data.application.users;

import com.sosnowka.data.application.base.BaseEntity;
import com.sosnowka.data.infrastructure.controllers.UserResponse;
import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "password")
class AppUser extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Long age;

    UserContext getUserContext() {
        return UserContext.builder()
                          .uuid(this.getUuid())
                          .age(this.age)
                          .email(this.email)
                          .userName(UserContext.UserName.of(this.firstName, this.lastName))
                          .build();

    }

    UserResponse toUserResponse() {
        return new UserResponse(
                this.getUuid(),
                this.firstName,
                this.lastName,
                this.email,
                this.age);
    }
}
