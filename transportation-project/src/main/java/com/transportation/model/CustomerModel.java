package com.transportation.model;

public class CustomerModel {

  private Long id;

  private Long userAccountId;

  public CustomerModel(Long id, Long userAccountId) {
    this.id = id;
    this.userAccountId = userAccountId;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }
}
