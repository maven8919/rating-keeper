package com.maven8919.ratingkeeper.user.transformer;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.maven8919.ratingkeeper.user.domain.UserEntity;
import com.maven8919.ratingkeeper.user.model.AddUserRequest;

@Component
public class AddUserRequestToUserEntityTransformer {

    public UserEntity transform(AddUserRequest addUserRequest) {
        UserEntity result = new UserEntity();
        result.setUsername(addUserRequest.getUsername());
        result.setPasswordHash(new BCryptPasswordEncoder().encode(addUserRequest.getPassword()));
        result.setUserRole(addUserRequest.getUserRole());
        return result;
    }

}
