package com.transportation.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "company_id")
  private Long companyId;
  @ManyToOne
  @JoinColumn(name = "company_id", updatable = false, insertable = false)
  @JsonBackReference
  private Company company;
  @Column
  private String number;
  @Column(name = "is_active")
  private Boolean isActive;
  @Column
  private LocalDate insuranceDate;
  @Column
  private LocalDate technicalInspectionDate;

  public Car(Long companyId, Company company, String number, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {
    this.companyId = companyId;
    this.company = company;
    this.number = number;
    this.isActive = isActive;
    this.insuranceDate = insuranceDate;
    this.technicalInspectionDate = technicalInspectionDate;
  }

  public Car() {
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

  public Company getCompany() {
    return company;
  }

  public void setCompany(Company company) {
    this.company = company;
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

  public void setActive(Boolean isActive) {
    this.isActive = isActive;
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
    Car car = (Car) o;
    return Objects.equals(id, car.id) && Objects.equals(
        companyId, car.companyId) && Objects.equals(company, car.company) && Objects.equals(number,
        car.number) && Objects.equals(isActive, car.isActive) && Objects.equals(insuranceDate,
        car.insuranceDate) && Objects.equals(technicalInspectionDate, car.technicalInspectionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, companyId, company, number, isActive, insuranceDate, technicalInspectionDate);
  }

  @Override
  public String toString() {
    return "Car{" +
        "id=" + id +
        ", companyId=" + companyId +
        ", company=" + company +
        ", number='" + number + '\'' +
        ", isActive=" + isActive +
        ", insuranceDate=" + insuranceDate +
        ", technicalInspectionDate=" + technicalInspectionDate +
        '}';
  }
}
