package com.transportation.controller;

import com.transportation.model.request.CreateCustomerRequest;
import com.transportation.service.CustomerService;
import com.transportation.service.UserAccountService;
import com.transportation.service.UserValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class RegistrationController {

  private final UserAccountService userService;
  private final UserValidationService userValidator;
  private final CustomerService customerService;

  public RegistrationController(UserAccountService userService,
      UserValidationService userValidator, CustomerService customerService) {
    this.userService = userService;
    this.userValidator = userValidator;
    this.customerService = customerService;
  }

  @PostMapping("/registration")
  public String registration(@RequestBody CreateCustomerRequest request,
      BindingResult bindingResult) {
    userValidator.validate(request, bindingResult);

    if (bindingResult.hasErrors()) {
      return "no ok";
    }

    customerService.create(request);
//    userService.loadUserByUsername(request.getEmail());

    return "ok";
  }
}
