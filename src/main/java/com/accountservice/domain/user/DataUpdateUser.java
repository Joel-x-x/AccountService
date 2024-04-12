package com.accountservice.domain.user;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
        @NotNull
        String user_id,
        String username,
        String fullname,
        String email
) {
}
