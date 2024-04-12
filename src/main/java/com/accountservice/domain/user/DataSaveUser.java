package com.accountservice.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataSaveUser(
        @NotBlank
        String username,
        @NotBlank
        String fullname,
        @NotBlank
        String email,
        @NotBlank
        String password
) {}
