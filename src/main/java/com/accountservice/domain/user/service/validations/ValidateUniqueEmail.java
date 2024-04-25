package com.accountservice.domain.user.service.validations;

import com.accountservice.domain.user.DataUpdateUser;
import com.accountservice.domain.user.UserRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidateUniqueEmail implements ValidationsUpdateUser{

    @Autowired
    UserRepository userRepository;
    @Override
    public void validate(DataUpdateUser dataUpdateUser) {
        if(dataUpdateUser.email() == null) {
            return;
        }

        if(userRepository.existsByEmail(dataUpdateUser.email())) {
            throw new ValidationException("This email already exists.");
        }
    }
}
