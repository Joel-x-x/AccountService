package com.accountservice.infra.error;

import java.util.List;

public class IntegrityValidation extends RuntimeException {
    public IntegrityValidation(String message) {
        super(message);
    }
}
