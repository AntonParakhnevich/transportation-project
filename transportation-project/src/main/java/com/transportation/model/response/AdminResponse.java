package com.transportation.model.response;

import java.util.Objects;

public class AdminResponse {

  private Long userId;
  private Long companyId;

  public AdminResponse(Long userId, Long companyId) {
    this.userId = userId;
    this.companyId = companyId;
  }

  public AdminResponse() {
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AdminResponse that = (AdminResponse) o;
    return Objects.equals(userId, that.userId) && Objects.equals(companyId, that.companyId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, companyId);
  }

  @Override
  public String toString() {
    return "AdminResponse{" +
        "userId=" + userId +
        ", companyId=" + companyId +
        '}';
  }
}
