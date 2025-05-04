package com.transportation.controller;

import com.transportation.model.request.CreateCustomerRequest;
import com.transportation.service.CustomerService;
import com.transportation.service.UserTools;
import com.transportation.service.UserValidationService;
import java.util.Optional;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

  private final CustomerService customerService;

  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping
  public String create(@RequestBody CreateCustomerRequest request) {
    return customerService.create(request);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
    String username = userDetails.getUsername();
    return Optional.ofNullable(customerService.getByEmail(username))
        .filter(customer -> customer.getId().equals(id) || UserTools.isAdmin(userDetails.getAuthorities()))
        .map(customer -> {
              customerService.delete(customer);
              return "ok";
            }
        )
        .orElse("no ok");
  }
}
