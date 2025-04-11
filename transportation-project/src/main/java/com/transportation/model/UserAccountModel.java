package com.transportation.model;

public class UserAccountModel {

  private Long id;
  private String name;
  private String phone;
  private RoleName roleName;
  private String password;
  private String email;

  public UserAccountModel(Long id, String name, String phone, RoleName roleName, String password, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.roleName = roleName;
    this.password = password;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public RoleName getRoleName() {
    return roleName;
  }

  public void setRoleName(RoleName roleName) {
    this.roleName = roleName;
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
}
