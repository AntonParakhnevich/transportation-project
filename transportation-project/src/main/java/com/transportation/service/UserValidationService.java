package com.transportation.service;

import com.transportation.model.request.CreateCustomerRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidationService implements Validator {

  private final UserAccountService userAccountService;

  public UserValidationService(UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  @Override
  public boolean supports(Class<?> clazz) {
    return false;
  }

  @Override
  public void validate(Object target, Errors errors) {
    CreateCustomerRequest user = (CreateCustomerRequest) target;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
    if (user.getName().length() < 2 || user.getName().length() > 32) {
      errors.rejectValue("name", "Size.userForm.username");
    }

    if (userAccountService.getByEmail(user.getEmail()) != null) {
      errors.rejectValue("email", "Duplicate.userForm.username");
    }

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
    if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
      errors.rejectValue("password", "Size.userForm.password");
    }
  }
}
