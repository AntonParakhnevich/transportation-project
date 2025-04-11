package com.transportation.model;

import java.time.LocalDate;

public class CarModel {

  private Long id;
  private Long companyId;
  private String number;
  private Boolean isActive;
  private LocalDate insuranceDate;
  private LocalDate technicalInspectionDate;

  public CarModel(Long id, Long companyId, String number, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {
    this.id = id;
    this.companyId = companyId;
    this.number = number;
    this.isActive = isActive;
    this.insuranceDate = insuranceDate;
    this.technicalInspectionDate = technicalInspectionDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getCompanyId() {
    return companyId;
  }

  public void setCompanyId(Long companyId) {
    this.companyId = companyId;
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
