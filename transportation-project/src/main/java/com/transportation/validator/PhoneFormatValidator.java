package com.transportation.validator;

import org.springframework.stereotype.Service;

@Service
public class PhoneFormatValidator implements Validator<String> {

  private final static String PHONE_REGEXP = "^\\+375(17|29|33|44)\\d{7}$";

  @Override
  public String validate(String phone) {
    if (!phone.matches(PHONE_REGEXP)) {
      return "Неверный формат телефона";
    }
    return null;
  }
}
