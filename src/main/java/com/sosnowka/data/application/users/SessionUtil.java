package com.sosnowka.data.application.users;

import com.sosnowka.data.application.users.dto.GetTokenRequest;
import com.sosnowka.data.application.users.dto.TokenResponse;
import com.sosnowka.data.infrastructure.security.SecurityConstants;
import com.sosnowka.data.infrastructure.security.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SessionUtil {
    private final SecurityConstants securityConstants;
    private final UserService userService;

    public TokenResponse generateToken(GetTokenRequest request) {
        final AppUser user = userService.getUserByCredentials(request);
        final String generate = TokenGenerator.generate(TokenGenerator.Payload.of(user.getEmail(), securityConstants.getExpiration()),
                                                        securityConstants.getSecret());
        return new TokenResponse(generate);
    }

}
