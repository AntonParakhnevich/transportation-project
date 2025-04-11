package com.transportation.mapper;

import com.transportation.model.CarModel;
import com.transportation.model.entity.Car;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CarMapper implements Mapper<CarModel, Car> {

  @Override
  public CarModel toModel(Car entity) {
    return new CarModel(
        entity.getId(),
        entity.getCompanyId(),
        entity.getNumber(),
        entity.getActive(),
        entity.getInsuranceDate(),
        entity.getTechnicalInspectionDate()
    );
  }

  @Override
  public List<CarModel> toModelList(List<Car> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
