package com.transportation.validator;

import org.springframework.stereotype.Service;

@Service
public class NameValidator implements Validator<String> {

  @Override
  public String validate(String name) {
    if (name == null || name.isEmpty()) {
      return "Отсутствует имя";
    }
    if (name.length() < 2) {
      return "Имя не может быть короче двух символов";
    }
    return null;
  }
}
