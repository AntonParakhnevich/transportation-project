package com.transportation.model;

public class AdminModel {

  private Long id;
  private Long userAccountId;
  private Long companyId;

  public AdminModel(Long id, Long userAccountId, Long companyId) {
    this.id = id;
    this.userAccountId = userAccountId;
    this.companyId = companyId;
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

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }
}
