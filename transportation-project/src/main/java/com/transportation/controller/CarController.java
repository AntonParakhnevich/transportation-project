package com.transportation.controller;

import com.transportation.model.request.CreateCarRequest;
import com.transportation.model.request.UpdateCarRequest;
import com.transportation.model.response.CarResponse;
import com.transportation.service.CarService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cars")
public class CarController {

  private final CarService carService;

  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping("/")
  public Long create(@RequestBody CreateCarRequest request) {
    return carService.create(request.getNumber(), request.getCompanyId(), request.getActive(),
        request.getInsuranceDate(), request.getTechnicalInspectionDate());
  }

  @GetMapping("/by-company/{companyId}")
  public List<CarResponse> getByCompanyId(@PathVariable("companyId") Long companyId) {
    return carService.getAllByCompanyId(companyId).stream()
        .map(carModel -> new CarResponse(
                carModel.getId(),
                carModel.getCompanyId(),
                carModel.getNumber(),
                carModel.getActive(),
                carModel.getInsuranceDate(),
                carModel.getTechnicalInspectionDate()
            )
        )
        .collect(Collectors.toList());
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable Long id) {
    return carService.deleteById(id);
  }

  @PutMapping("/{id}")
  public String updateById(@PathVariable("id") Long id, @RequestBody UpdateCarRequest request) {
    return carService.updateCarRequest(request, id);
  }
}
