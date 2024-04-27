package com.example.ecommerceplatform.security;

import com.example.ecommerceplatform.dto.TokenResponse;
import com.example.ecommerceplatform.dto.UserCredentialsDTO;
import com.example.ecommerceplatform.model.token.Token;
import com.example.ecommerceplatform.model.token.TokenType;
import com.example.ecommerceplatform.model.user.User;
import com.example.ecommerceplatform.repository.TokenRepository;
import com.example.ecommerceplatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public TokenResponse authenticate(UserCredentialsDTO userCredentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userCredentials.username(),
                        userCredentials.password()
                )
        );
        User user = userRepository.findUserByEmail(userCredentials.username())
                .orElseThrow();
        var jwtToken = jwtService.generateToken((UserDetails) user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return new TokenResponse(jwtToken);
    }

    private void saveUserToken(User user, String jwtToken) {
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }


}
