package com.maven8919.ratingkeeper.user.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.maven8919.ratingkeeper.user.domain.UserRole;

public class AddUserRequest {
    
    @NotNull
    @Size(min = 1, max = 255, message = "Please enter your username.")
    private String username;
    
    @NotNull
    @Size(min = 1, max = 255, message = "Please enter your password.")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 255, message = "Please enter your password confirmation.")
    private String passwordConfirmation;
    
    @NotNull
    private UserRole userRole = UserRole.USER;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
    
}
