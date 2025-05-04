package com.transportation.model.response;

import java.time.LocalDate;
import java.util.Objects;

public class CarResponse {

  private Long id;
  private Long companyId;
  private String number;
  private Boolean isActive;
  private LocalDate insuranceDate;
  private LocalDate technicalInspectionDate;

  public CarResponse(Long id, Long companyId, String number, Boolean isActive, LocalDate insuranceDate,
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarResponse that = (CarResponse) o;
    return Objects.equals(id, that.id) && Objects.equals(companyId, that.companyId)
        && Objects.equals(number, that.number) && Objects.equals(isActive, that.isActive)
        && Objects.equals(insuranceDate, that.insuranceDate) && Objects.equals(
        technicalInspectionDate, that.technicalInspectionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, companyId, number, isActive, insuranceDate, technicalInspectionDate);
  }

  @Override
  public String toString() {
    return "CarResponse{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", number='" + number + '\'' +
        ", isActive=" + isActive +
        ", insuranceDate=" + insuranceDate +
        ", technicalInspectionDate=" + technicalInspectionDate +
        '}';
  }
}
