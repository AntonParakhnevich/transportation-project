package com.transportation.repository;

import com.transportation.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

  @Query("select a from Admin a "
      + " join UserAccount ua on a.userAccountId=ua.id"
      + " where ua.email = :email")
  Admin findByEmail(String email);
}
