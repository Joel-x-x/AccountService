package com.accountservice.domain.user.service;

import com.accountservice.domain.user.DataUpdateUser;
import com.accountservice.domain.user.UserEntity;
import com.accountservice.domain.user.UserRepository;
import com.accountservice.domain.user.service.validations.ValidationsUpdateUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UpdateUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    List<ValidationsUpdateUser> validations;

    @Transactional
    public UserEntity update(DataUpdateUser dataUpdateUser) {
        // Validating one by one
        validations.forEach(validation -> validation.validate(dataUpdateUser));

        UserEntity userEntity = userRepository.findById(UUID.fromString(dataUpdateUser.user_id())).get();

        userEntity.update(dataUpdateUser);

        return userEntity;
    }
}
