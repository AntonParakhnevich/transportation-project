package com.transportation.service;

import com.transportation.mapper.CompanyMapper;
import com.transportation.model.CompanyModel;
import com.transportation.model.entity.Company;
import com.transportation.repository.CompanyRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CompanyService {

  private final CompanyRepository companyRepository;
  private final CompanyValidationService companyValidationService;
  private final CompanyMapper companyMapper;

  public CompanyService(CompanyRepository companyRepository, CompanyValidationService companyValidationService,
      CompanyMapper companyMapper) {
    this.companyRepository = companyRepository;
    this.companyValidationService = companyValidationService;
    this.companyMapper = companyMapper;
  }

  public String create(String name, String address, String phone) {
    Company company = new Company();
    company.setName(name);
    company.setPhone(phone);
    company.setAddress(address);

    String validateErrorMessage = companyValidationService.validate(company);
    if (validateErrorMessage != null) {
      return validateErrorMessage;
    }

    companyRepository.save(company);
    return "success";
  }

  public CompanyModel getById(Long id) {
    return companyRepository.findById(id)
        .map(companyMapper::toModel)
        .orElseThrow(() -> new IllegalArgumentException("Company with id=" + id + " not found"));
  }

  public String deleteById(Long id) {
    return Optional.of(companyRepository.existsById(id))
        .filter(isExistById -> isExistById)
        .map(isExistById -> {
          companyRepository.deleteById(id);
          return "success";
        })
        .orElse(String.format("company not found, id=%s", id));
  }

  public List<CompanyModel> getAll() {
    return companyMapper.toModelList(companyRepository.findAll());
  }
}
