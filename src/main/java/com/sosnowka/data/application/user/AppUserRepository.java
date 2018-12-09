package com.sosnowka.data.application.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface AppUserRepository extends JpaRepository<AppUser, Long> {
}
