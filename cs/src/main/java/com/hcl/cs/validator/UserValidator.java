package com.hcl.cs.validator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hcl.cs.dto.UserDTO;
import com.hcl.cs.service.UserService;


@Component
public class UserValidator implements Validator{
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "NotEmpty");
        if (user.getUserName().length() < 4 || user.getUserName().length() > 32) {
            errors.rejectValue("userName", "Size.userForm.userName");
        }
        if (userService.findByUserName(user.getUserName()) != null) {
            errors.rejectValue("userName", "Duplicate.userForm.userName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPassword", "NotEmpty");
        if (user.getUserPassword().length() < 4 || user.getUserPassword().length() > 32) {
            errors.rejectValue("userPassword", "Size.userForm.userPassword");
        }

        if (!user.getConfirmPassword().equals(user.getUserPassword())) {
            errors.rejectValue("confirmPassword", "Diff.userForm.confirmPassword");
        }
    }
}
