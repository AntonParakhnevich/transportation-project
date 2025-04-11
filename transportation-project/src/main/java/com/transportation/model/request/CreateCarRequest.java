package com.transportation.model.request;

import java.time.LocalDate;

public class CreateCarRequest {

  private String number;
  private Long companyId;
  private Boolean isActive;
  private LocalDate insuranceDate;
  private LocalDate technicalInspectionDate;

  public CreateCarRequest(String number, Long companyId, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {
    this.number = number;
    this.companyId = companyId;
    this.isActive = isActive;
    this.insuranceDate = insuranceDate;
    this.technicalInspectionDate = technicalInspectionDate;
  }

  public CreateCarRequest() {
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
  }

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }

  public LocalDate getInsuranceDate() {
    return insuranceDate;
  }

  public void setInsuranceDate(LocalDate insuranceDate) {
    this.insuranceDate = insuranceDate;
  }

  public LocalDate getTechnicalInspectionDate() {
    return technicalInspectionDate;
  }

  public void setTechnicalInspectionDate(LocalDate technicalInspectionDate) {
    this.technicalInspectionDate = technicalInspectionDate;
  }
}
