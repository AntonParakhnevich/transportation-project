package com.transportation.controller;

import com.transportation.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private-area")
public class PrivateAreaController {

  private final CustomerService customerService;

  public PrivateAreaController(CustomerService customerService) {
    this.customerService = customerService;
  }
}
