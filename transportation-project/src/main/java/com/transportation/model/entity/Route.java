package com.transportation.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "city_from", insertable = false, updatable = false)
  private String cityFrom;

  @Column(name = "city_to", insertable = false, updatable = false)
  private String cityTo;

  public Route() {
  }

  public Route(Long id, String cityFrom, String cityTo) {
    this.id = id;
    this.cityFrom = cityFrom;
    this.cityTo = cityTo;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCityFrom() {
    return cityFrom;
  }

  public void setCityFrom(String cityFrom) {
    this.cityFrom = cityFrom;
  }

  public String getCityTo() {
    return cityTo;
  }

  public void setCityTo(String cityTo) {
    this.cityTo = cityTo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Route route = (Route) o;
    return Objects.equals(id, route.id) && Objects.equals(cityFrom, route.cityFrom)
        && Objects.equals(cityTo, route.cityTo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, cityFrom, cityTo);
  }

  @Override
  public String toString() {
    return "Route{" +
        "id=" + id +
        ", cityFrom='" + cityFrom + '\'' +
        ", cityTo='" + cityTo + '\'' +
        '}';
  }
}
