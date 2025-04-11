package com.transportation.mapper;

import com.transportation.model.CustomerModel;
import com.transportation.model.entity.Customer;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements Mapper<CustomerModel, Customer> {

  @Override
  public CustomerModel toModel(Customer entity) {
    return new CustomerModel(
        entity.getId(),
        entity.getUserAccountId()
    );
  }

  @Override
  public List<CustomerModel> toModelList(List<Customer> entities) {
    return entities.stream()
        .map(this::toModel)
        .collect(Collectors.toList());
  }
}
