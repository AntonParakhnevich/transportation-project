package com.transportation.model.request;

import java.time.LocalDate;

public class UpdateCarRequest {

  private String number;
  private Boolean isActive;
  private LocalDate insuranceDate;
  private LocalDate technicalInspectionDate;

  public UpdateCarRequest(String number, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {
    this.number = number;
    this.isActive = isActive;
    this.insuranceDate = insuranceDate;
    this.technicalInspectionDate = technicalInspectionDate;
  }

  public UpdateCarRequest() {
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
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
