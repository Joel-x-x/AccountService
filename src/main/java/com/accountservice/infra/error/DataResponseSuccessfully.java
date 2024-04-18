package com.accountservice.infra.error;

import org.springframework.http.HttpStatus;

public record DataResponseSuccessfully(
        String status,
        String message
) {
}
