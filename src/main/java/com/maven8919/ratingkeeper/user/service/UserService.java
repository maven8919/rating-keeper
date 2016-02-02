package com.maven8919.ratingkeeper.user.service;

import java.util.Collection;
import java.util.Optional;

import com.maven8919.ratingkeeper.user.domain.UserEntity;

public interface UserService {

    Optional<UserEntity> getUserById(Long id);
    Optional<UserEntity> getUserByUsername(String username);
    Collection<UserEntity> getAllUsers();
    UserEntity saveUser(UserEntity userEntity);
    
}
