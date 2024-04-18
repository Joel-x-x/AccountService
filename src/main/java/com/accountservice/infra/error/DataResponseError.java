package com.accountservice.infra.error;

import org.springframework.http.HttpStatus;

import java.util.List;

public record DataResponseError(
        String status,
        List<String> errors
) {
}
