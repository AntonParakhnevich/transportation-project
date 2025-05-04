package com.transportation.repository;

import com.transportation.model.entity.Car;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  List<Car> findAllByCompanyId(Long companyId);
}
