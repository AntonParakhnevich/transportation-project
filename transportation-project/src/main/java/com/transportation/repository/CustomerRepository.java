package com.transportation.repository;

import com.transportation.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  @Query("select c from Customer c "
      + " join UserAccount ua on c.userAccountId=ua.id"
      + " where ua.email = :email")
  Customer findByEmail(String email);
}
