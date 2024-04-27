package com.example.ecommerceplatform.controller;
import com.example.ecommerceplatform.dto.TokenResponse;
import com.example.ecommerceplatform.dto.UserCredentialsDTO;
import com.example.ecommerceplatform.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class LoginController {
    private final AuthenticationService service;

    @PostMapping("/login")
    ResponseEntity<TokenResponse> login(@RequestBody UserCredentialsDTO userCredentialsdto) {
        return ResponseEntity.ok(service.authenticate(userCredentialsdto));
    }
}
