package com.transportation.mapper;

import com.transportation.model.AdminModel;
import com.transportation.model.entity.Admin;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AdminMapper implements Mapper<AdminModel, Admin> {

  @Override
  public AdminModel toModel(Admin entity) {
    return new AdminModel(
        entity.getId(),
        entity.getUserAccountId(),
        entity.getCompanyId()
    );
  }

  @Override
  public List<AdminModel> toModelList(List<Admin> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
