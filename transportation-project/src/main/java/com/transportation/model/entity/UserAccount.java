package com.transportation.model.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column
  private String name;
  @Column
  private String phone;
  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
  @JoinColumn(name = "role_id", insertable = false, updatable = false)
  private Role role;
  @Column(name = "role_id")
  private Long roleId;
  @Column
  private String password;
  @Column
  private String email;

  public UserAccount(Long id, String name, String phone, Role role, String password,
      String email, Long roleId) {
    this.id = id;
    this.roleId = roleId;
    this.name = name;
    this.phone = phone;
    this.role = role;
    this.password = password;
    this.email = email;
  }

  public UserAccount() {
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserAccount that = (UserAccount) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(
        phone, that.phone) && Objects.equals(role, that.role) && Objects.equals(roleId, that.roleId)
        && Objects.equals(password, that.password) && Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, phone, role, roleId, password, email);
  }

  @Override
  public String toString() {
    return "UserAccount{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", phone='" + phone + '\'' +
        ", role=" + role +
        ", roleId=" + roleId +
        ", password='" + password + '\'' +
        ", email='" + email + '\'' +
        '}';
  }
}
