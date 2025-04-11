package com.transportation.validator;

public interface Validator<T> {

  String validate(T value);
}
