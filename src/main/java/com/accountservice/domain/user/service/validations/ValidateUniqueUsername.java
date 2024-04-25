package com.accountservice.domain.user.service.validations;

import com.accountservice.domain.user.DataUpdateUser;
import com.accountservice.domain.user.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUniqueUsername implements ValidationsUpdateUser{

    @Autowired
    UserRepository userRepository;

    @Override
    public void validate(DataUpdateUser dataUpdateUser) {
        if(dataUpdateUser.username() == null) {
            return;
        }

        if(userRepository.existsByUsername(dataUpdateUser.username())) {
            throw new ValidationException("This username already exists");
        }
    }
}
