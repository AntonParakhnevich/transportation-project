package com.transportation.model.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_account_id", insertable = false, updatable = false)
  private Long userAccountId;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "user_account_id")
  private UserAccount userAccount;

  public Customer(Long id, Long userAccountId, UserAccount userAccount) {
    this.id = id;
    this.userAccountId = userAccountId;
    this.userAccount = userAccount;
  }

  public Customer() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserAccountId() {
    return userAccountId;
  }

  public void setUserAccountId(Long userAccountId) {
    this.userAccountId = userAccountId;
  }

  public UserAccount getUserAccount() {
    return userAccount;
  }

  public void setUserAccount(UserAccount userAccount) {
    this.userAccount = userAccount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(id, customer.id) && Objects.equals(userAccountId, customer.userAccountId)
        && Objects.equals(userAccount, customer.userAccount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userAccountId, userAccount);
  }

  @Override
  public String toString() {
    return "Customer{" +
        "id=" + id +
        ", userAccountId=" + userAccountId +
        ", userAccount=" + userAccount +
        '}';
  }
}
