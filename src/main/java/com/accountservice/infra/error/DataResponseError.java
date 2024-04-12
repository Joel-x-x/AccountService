package com.accountservice.infra.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public record DataResponseError(
        HttpStatus status,
        List<String> errors
) {
}
