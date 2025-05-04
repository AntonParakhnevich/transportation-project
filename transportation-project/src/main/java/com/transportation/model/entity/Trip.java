package com.transportation.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.transportation.model.TripStatus;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "trip")
public class Trip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "route_id", updatable = false, insertable = false)
  @JsonBackReference
  private Route route;
  @Column(name = "company_id")
  private Long companyId;
  @ManyToOne
  @JoinColumn(name = "company_id", updatable = false, insertable = false)
  @JsonBackReference
  private Company company;
  @Column(name = "car_id")
  private Long carId;
  @ManyToOne
  @JoinColumn(name = "car_id", updatable = false, insertable = false)
  @JsonBackReference
  private Car car;
  @Column(name = "date")
  private LocalDateTime date;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private TripStatus status;

  public Trip() {
  }

  public Trip(Long id, Route route, Long companyId, Company company, Long carId, Car car, LocalDateTime date,
      TripStatus status) {
    this.id = id;
    this.route = route;
    this.companyId = companyId;
    this.company = company;
    this.carId = carId;
    this.car = car;
    this.date = date;
    this.status = status;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Route getRoute() {
    return route;
  }

  public void setRoute(Route route) {
    this.route = route;
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

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public TripStatus getStatus() {
    return status;
  }

  public void setStatus(TripStatus status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Trip trip = (Trip) o;
    return Objects.equals(id, trip.id) && Objects.equals(route, trip.route)
        && Objects.equals(companyId, trip.companyId) && Objects.equals(company, trip.company)
        && Objects.equals(carId, trip.carId) && Objects.equals(car, trip.car)
        && Objects.equals(date, trip.date) && status == trip.status;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, route, companyId, company, carId, car, date, status);
  }

  @Override
  public String toString() {
    return "Trip{" +
        "id=" + id +
        ", route=" + route +
        ", companyId=" + companyId +
        ", company=" + company +
        ", carId=" + carId +
        ", car=" + car +
        ", date=" + date +
        ", status=" + status +
        '}';
  }
}
