package com.transportation.controller;

import com.transportation.model.CompanyModel;
import com.transportation.model.request.CreateCompanyRequest;
import com.transportation.service.CompanyService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {

  private final CompanyService companyService;

  public CompanyController(CompanyService companyService) {
    this.companyService = companyService;
  }

  @PostMapping("/")
  public String create(@RequestBody CreateCompanyRequest request) {
    return companyService.create(request.getName(), request.getAddress(), request.getPhone());
  }

  @GetMapping("/{id}")
  public CompanyModel getById(@PathVariable Long id) {
    return companyService.getById(id);
  }

  @DeleteMapping("/{id}")
  public String deleteById(@PathVariable Long id) {
    return companyService.deleteById(id);
  }
}
