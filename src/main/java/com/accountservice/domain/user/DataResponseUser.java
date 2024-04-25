package com.accountservice.domain.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record DataResponseUser(
        UUID user_id,
        String username,
        String fullname,
        String email,
        LocalDateTime created,
        LocalDateTime updated,
        Boolean exists,
        String apiKey,
        Boolean email_confirmed
) {
    public DataResponseUser(UserEntity userEntity) {
        this(userEntity.getUser_id(),userEntity.getUsername(), userEntity.getFullname(), userEntity.getEmail(), userEntity.getCreated(), userEntity.getUpdated(), userEntity.getExists(), userEntity.getApiKey(), userEntity.getEmail_confirmed());
    }
}
