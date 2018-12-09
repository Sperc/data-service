package com.sosnowka.data.application.playground;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface PlaygroundRepository extends JpaRepository<Playground, Long> {
    Optional<Playground> findByUuid(String uuid);
}
