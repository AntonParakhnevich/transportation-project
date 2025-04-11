package com.transportation.model;

import java.util.Objects;

public class CreateUserAccountModel {

  private String name;
  private String phone;
  private RoleName role;
  private String password;
  private String email;

  public CreateUserAccountModel(String name, String phone, RoleName role, String password, String email) {
    this.name = name;
    this.phone = phone;
    this.role = role;
    this.password = password;
    this.email = email;
  }

  public CreateUserAccountModel() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public RoleName getRole() {
    return role;
  }

  public void setRole(RoleName role) {
    this.role = role;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserAccountModel that = (CreateUserAccountModel) o;
    return Objects.equals(name, that.name) && Objects.equals(phone, that.phone) && role == that.role
        && Objects.equals(password, that.password) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, phone, role, password, email);
  }

  @Override
  public String toString() {
    return "CreateUserAccountModel{" +
        "name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", role=" + role +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
