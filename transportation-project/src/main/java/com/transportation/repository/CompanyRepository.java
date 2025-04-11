package com.transportation.repository;

import com.transportation.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

  Integer countByPhoneAndName(String phone, String name);
}
