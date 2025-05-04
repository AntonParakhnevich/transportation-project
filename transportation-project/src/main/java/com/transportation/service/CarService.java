package com.transportation.service;

import com.transportation.mapper.CarMapper;
import com.transportation.model.CarModel;
import com.transportation.model.entity.Car;
import com.transportation.model.request.UpdateCarRequest;
import com.transportation.repository.CarRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final CarRepository carRepository;
  private final CarMapper carMapper;

  public CarService(CarRepository carRepository, CarMapper carMapper) {
    this.carRepository = carRepository;
    this.carMapper = carMapper;
  }

  public Long create(String number, Long companyId, Boolean isActive, LocalDate insuranceDate,
      LocalDate technicalInspectionDate) {

    Car car = new Car();
    car.setNumber(number);
    car.setCompanyId(companyId);
    car.setActive(isActive);
    car.setInsuranceDate(insuranceDate);
    car.setTechnicalInspectionDate(technicalInspectionDate);

    return carRepository.save(car).getId();
  }

  public List<CarModel> getAllByCompanyId(Long companyId) {
    return Optional.ofNullable(carRepository.findAllByCompanyId(companyId))
        .map(carMapper::toModelList)
        .orElse(new ArrayList<>());
  }

  public String deleteById(Long id) {
    return Optional.of(carRepository.existsById(id))
        .filter(isExistById -> isExistById)
        .map(isExistById -> {
          carRepository.deleteById(id);
          return "success";
        })
        .orElse(String.format("company not found, id=%s", id));
  }

  public String updateCarRequest(UpdateCarRequest request, Long id) {
    return carRepository.findById(id)
        .map(car -> {
          updateField(request.getActive(), car::setActive);
          updateField(request.getNumber(), car::setNumber);
          updateField(request.getInsuranceDate(), car::setInsuranceDate);
          updateField(request.getTechnicalInspectionDate(), car::setTechnicalInspectionDate);
          carRepository.save(car);
          return "success";
        })
        .orElse(String.format("car not found, id=%s", id));
  }

  private <T> void updateField(T newValue, Consumer<T> setter) {
    if (newValue != null) {
      setter.accept(newValue);
    }
  }
}
