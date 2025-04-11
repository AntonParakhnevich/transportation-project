package com.transportation.mapper;

import com.transportation.model.CompanyModel;
import com.transportation.model.entity.Company;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper implements Mapper<CompanyModel, Company> {

  @Override
  public CompanyModel toModel(Company entity) {
    return new CompanyModel(
        entity.getId(),
        entity.getName(),
        entity.getPhone(),
        entity.getAddress()
    );
  }

  @Override
  public List<CompanyModel> toModelList(List<Company> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
