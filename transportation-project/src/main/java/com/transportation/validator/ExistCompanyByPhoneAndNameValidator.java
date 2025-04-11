package com.transportation.validator;

import com.transportation.model.entity.Company;
import com.transportation.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class ExistCompanyByPhoneAndNameValidator implements Validator<Company> {

  private final CompanyRepository companyRepository;

  public ExistCompanyByPhoneAndNameValidator(CompanyRepository companyRepository) {
    this.companyRepository = companyRepository;
  }

  @Override
  public String validate(Company company) {
    Integer countByPhone = companyRepository.countByPhoneAndName(company.getPhone(), company.getName());
    if (countByPhone > 0) {
      return "Компания с данным номером и именем уже зарегистрирована";
    }
    return null;
  }
}
