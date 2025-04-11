package com.transportation.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String phone;
  @Column
  private String address;
  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Admin> admins;
  @Column
  @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
  @JsonManagedReference
  private List<Car> cars;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public List<Admin> getAdmins() {
    return admins;
  }

  public void setAdmins(List<Admin> admins) {
    this.admins = admins;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Company company = (Company) o;
    return Objects.equals(id, company.id) && Objects.equals(name, company.name)
        && Objects.equals(phone, company.phone) && Objects.equals(address, company.address)
        && Objects.equals(admins, company.admins) && Objects.equals(cars, company.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, address, admins, cars);
  }

  @Override
  public String toString() {
    return "Company{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", address='" + address + '\'' +
//        ", admins=" + admins +
        ", cars=" + cars +
        '}';
  }
}
