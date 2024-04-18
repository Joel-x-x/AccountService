package com.accountservice.controller;

import com.accountservice.domain.user.DataResponseUser;
import com.accountservice.domain.user.DataSaveUser;
import com.accountservice.domain.user.UserEntity;
import com.accountservice.domain.user.UserRepository;
import com.accountservice.infra.error.DataResponseSuccessfully;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<DataResponseSuccessfully> createUser(@RequestBody @Valid DataSaveUser dataSaveUser, UriComponentsBuilder uriComponentsBuilder) {
        UserEntity userEntity = userRepository.save(new UserEntity(dataSaveUser, passwordEncoder.encode(dataSaveUser.password())));

        URI uri = uriComponentsBuilder.path("/api/v1/users/{id}").buildAndExpand(userEntity.getUser_id()).toUri();

        return ResponseEntity.created(uri).body(new DataResponseSuccessfully("201", "User " + userEntity.getUsername() + " has been created successfully"));
    }

    @GetMapping
    public ResponseEntity<Page<DataResponseUser>> listUsers(Pageable pageable) {
        return ResponseEntity.ok(userRepository.findAll(pageable).map(DataResponseUser::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponseUser> getUserData(@PathVariable UUID id) {
        UserEntity userEntity = userRepository.findById(id).get();

        return ResponseEntity.ok(new DataResponseUser(userEntity));
    }
}
