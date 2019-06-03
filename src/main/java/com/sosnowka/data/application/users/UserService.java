package com.sosnowka.data.application.users;

import com.sosnowka.data.application.base.DataException;
import com.sosnowka.data.application.users.dto.AddUserRequest;
import com.sosnowka.data.application.users.dto.GetTokenRequest;
import com.sosnowka.data.infrastructure.ApiErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    AppUser addUser(AddUserRequest addUserRequest) {
        Optional<AppUser> firstByEmail = userRepository.findByEmail(addUserRequest.getEmail());
        if (firstByEmail.isPresent()) {
            throw new DataException(ApiErrorCode.USER_EXISTS, "Email exists", HttpStatus.BAD_REQUEST);
        }
        AppUser user = new AppUser(addUserRequest.getFirstName(),
                                   addUserRequest.getLastName(),
                                   addUserRequest.getEmail(),
                                   passwordEncoder.encode(addUserRequest.getPassword()),
                                   addUserRequest.getAge());
        log.info("Add user: {}", user);
        return userRepository.save(user);
    }

    AppUser getUserByCredentials(GetTokenRequest getTokenRequest) {
        return userRepository.findByEmail(getTokenRequest.getUsername())
                             .filter(user -> isPasswordMatches(getTokenRequest.getPassword(), user.getPassword()))
                             .orElseThrow(() -> new DataException(ApiErrorCode.CANT_FIND_USER, "Cant'find user", HttpStatus.BAD_REQUEST));
    }

    private boolean isPasswordMatches(String requestPassword, String password) {
        return passwordEncoder.matches(requestPassword, password);
    }
}
