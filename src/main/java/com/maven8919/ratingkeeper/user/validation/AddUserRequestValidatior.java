package com.maven8919.ratingkeeper.user.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.maven8919.ratingkeeper.user.model.AddUserRequest;
import com.maven8919.ratingkeeper.user.service.UserService;

@Component
public class AddUserRequestValidatior implements Validator {
	
	private UserService userService;
	
	@Autowired
	public AddUserRequestValidatior(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(AddUserRequest.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		AddUserRequest addUserRequest = (AddUserRequest) target;
		validatePasswords(addUserRequest, errors);
		validateUsername(addUserRequest, errors);
	}

	private void validateUsername(AddUserRequest addUserRequest, Errors errors) {
		String password = addUserRequest.getPassword();
		String passwordConfirmation = addUserRequest.getPasswordConfirmation();
		if (!password.equals(passwordConfirmation)) {
			errors.reject("passwordsnotmatching", "The passwords are not matching, please review.");
		}
	}

	private void validatePasswords(AddUserRequest addUserRequest, Errors errors) {
		if (userService.getUserByUsername(addUserRequest.getUsername().trim()).isPresent()) {
			errors.reject("usernametaken", "The " + addUserRequest.getUsername().trim() + " handle is taken, please choose another one.");
		}
	}

}
