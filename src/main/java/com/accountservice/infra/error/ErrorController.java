package com.accountservice.infra.error;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> tratarError404() {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> tratarNullPointerException(Exception e) {
        return ResponseEntity.badRequest().body(new DataResponseError("400", new ArrayList<>(List.of(e.getMessage()))));
    }
    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity<?> errorHandlerBusinessValidation(Exception e) {
        return ResponseEntity.badRequest().body(new DataResponseError("400", new ArrayList<>(List.of(e.getMessage()))));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> tratarError400(MethodArgumentNotValidException e) {
        List<DataErrorValidation> dataErrorValidation = e.getFieldErrors().stream().map(DataErrorValidation::new).toList();
        return ResponseEntity.badRequest().body(dataErrorValidation);
    }

    private record DataErrorValidation(String campo, String error) {
        public DataErrorValidation(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
