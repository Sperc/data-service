package com.sosnowka.data.application.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String uuid = UUID.randomUUID().toString();
    private LocalDateTime createDate = LocalDateTime.now();

    @Override

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(id, that.id) &&
               Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uuid);
    }
}
