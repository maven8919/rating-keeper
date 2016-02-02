package com.maven8919.ratingkeeper.user.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maven8919.ratingkeeper.user.domain.UserEntity;
import com.maven8919.ratingkeeper.user.repository.UserRepository;
import com.maven8919.ratingkeeper.user.service.UserService;
import com.maven8919.ratingkeeper.user.transformer.AddUserRequestToUserEntityTransformer;

@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AddUserRequestToUserEntityTransformer addUserRequestToUserEntityTransformer) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserEntity> getUserById(Long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<UserEntity> getUserByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    @Override
    public Collection<UserEntity> getAllUsers() {
        return userRepository.findAll(new Sort("username"));
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

}
