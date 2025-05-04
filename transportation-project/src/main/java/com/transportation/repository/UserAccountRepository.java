package com.transportation.repository;

import com.transportation.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

  Integer countByPhone(String phone);

  UserAccount findByEmail(String email);

  UserAccount findByPhone(String phone);
}
