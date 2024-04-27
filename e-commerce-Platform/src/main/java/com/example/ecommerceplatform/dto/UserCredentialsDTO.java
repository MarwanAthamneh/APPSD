package com.example.ecommerceplatform.dto;

import jakarta.validation.constraints.NotNull;

public record UserCredentialsDTO(@NotNull String username, @NotNull String password) {
}
