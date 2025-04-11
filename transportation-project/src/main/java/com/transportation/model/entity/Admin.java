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
@Table(name = "admin")
public class Admin {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_account_id", insertable = false, updatable = false)
  private Long userAccountId;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(name = "user_account_id")
  private UserAccount userAccount;

  @Column(name = "company_id")
  private Long companyId;
  @ManyToOne
  @JoinColumn(name = "company_id", updatable = false, insertable = false)
  @JsonBackReference
  private Company company;

  public Admin() {
  }

  public Admin(Long id, Long userAccountId, UserAccount userAccount, Long companyId) {
    this.id = id;
    this.userAccountId = userAccountId;
    this.userAccount = userAccount;
    this.companyId = companyId;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Admin admin = (Admin) o;
    return Objects.equals(id, admin.id) && Objects.equals(userAccountId, admin.userAccountId)
        && Objects.equals(userAccount, admin.userAccount) && Objects.equals(companyId, admin.companyId)
        && Objects.equals(company, admin.company);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userAccountId, userAccount, companyId, company);
  }

  @Override
  public String toString() {
    return "Admin{" +
        "id=" + id +
        ", userAccountId=" + userAccountId +
        ", userAccount=" + userAccount +
        ", companyId=" + companyId +
//        ", company=" + company +
        '}';
  }
}
