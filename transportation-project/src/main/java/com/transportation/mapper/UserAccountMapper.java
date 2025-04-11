package com.transportation.mapper;

import com.transportation.model.UserAccountModel;
import com.transportation.model.entity.UserAccount;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserAccountMapper implements Mapper<UserAccountModel, UserAccount> {

  @Override
  public UserAccountModel toModel(UserAccount entity) {
    return new UserAccountModel(
        entity.getId(),
        entity.getName(),
        entity.getEmail(),
        entity.getRole().getName(),
        entity.getPassword(),
        entity.getEmail()
    );
  }

  @Override
  public List<UserAccountModel> toModelList(List<UserAccount> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
