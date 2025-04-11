package com.transportation.controller;

import com.transportation.model.CustomerModel;
import com.transportation.service.CustomerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private-area")
public class PrivateAreaController {

  private final CustomerService customerService;

  public PrivateAreaController(CustomerService customerService) {
    this.customerService = customerService;
  }


}
