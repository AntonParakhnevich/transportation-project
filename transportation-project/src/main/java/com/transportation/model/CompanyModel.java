package com.transportation.model;

public class CompanyModel {

  private Long id;
  private String name;
  private String phone;
  private String address;

  public CompanyModel(Long id, String name, String phone, String address) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.address = address;
  }

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
}
