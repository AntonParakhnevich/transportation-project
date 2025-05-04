package com.transportation.service;

import com.transportation.model.CreateUserAccountModel;
import com.transportation.model.entity.UserAccount;
import com.transportation.repository.UserAccountRepository;
import com.transportation.validator.UserPhoneValidator;
import org.springframework.stereotype.Service;

@Service
public class UserAccountValidationService implements ValidationService<CreateUserAccountModel> {

  private final UserPhoneValidator userPhoneValidator;
  private final UserAccountRepository userAccountRepository;

  public UserAccountValidationService(UserPhoneValidator userPhoneValidator,
      UserAccountRepository userAccountRepository) {
    this.userPhoneValidator = userPhoneValidator;
    this.userAccountRepository = userAccountRepository;
  }

  @Override
  public String validate(CreateUserAccountModel userAccount) {
    String phoneValidateError = userPhoneValidator.validate(userAccount.getPhone());
    if (phoneValidateError != null) {
      return phoneValidateError;
    }
    if (userAccount.getName() == null || userAccount.getName().isEmpty()) {
      return "name must not be null";
    }
    if (userAccount.getName().length() < 2 || userAccount.getName().length() > 32) {
      return "Username must be between 8 and 32 characters";
    }
    if (userAccount.getPassword().length() < 8 || userAccount.getPassword().length() > 32) {
      return "Password must be more than 8 and less than 32 characters";
    }
    if (userAccountRepository.findByEmail(userAccount.getEmail()) != null) {
      return "Such email already exists";
    }

    return null;
  }
}
