package com.accountservice.infra.error;

import org.springframework.http.HttpStatus;

public record DataResponseSuccessfully(
        HttpStatus status,
        String message
) {
}
