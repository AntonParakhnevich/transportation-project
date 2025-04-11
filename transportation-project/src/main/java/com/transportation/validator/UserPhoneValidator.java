package com.transportation.validator;

import com.transportation.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class UserPhoneValidator implements Validator<String> {

  private final UserAccountRepository userAccountRepository;
  private final PhoneFormatValidator phoneFormatValidator;

  public UserPhoneValidator(UserAccountRepository userAccountRepository, PhoneFormatValidator phoneFormatValidator) {
    this.userAccountRepository = userAccountRepository;
    this.phoneFormatValidator = phoneFormatValidator;
  }

  @Override
  public String validate(String phone) {
    String formatValidationError = phoneFormatValidator.validate(phone);
    if (formatValidationError != null) {
      return formatValidationError;
    }
    Integer countByPhone = userAccountRepository.countByPhone(phone);
    if (countByPhone > 0) {
      return "Пользователь с данным номером уже зарегистрирован";
    }
    return null;
  }
}
