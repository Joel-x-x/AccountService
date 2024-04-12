package com.accountservice.domain.user;

import java.util.UUID;

public record DataResponseUser(
        UUID user_id,
        String username,
        String fullname,
        String email,
        Boolean email_confirmed
) {
    public DataResponseUser(UserEntity userEntity) {
        this(userEntity.getUser_id(),userEntity.getUsername(), userEntity.getFullname(), userEntity.getEmail(), userEntity.getEmail_confirmed());
    }
}
