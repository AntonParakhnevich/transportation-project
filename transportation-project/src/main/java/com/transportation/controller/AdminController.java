package com.transportation.controller;

import com.transportation.model.request.CreateAdminRequest;
import com.transportation.model.response.AdminResponse;
import com.transportation.service.AdminService;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admins")
public class AdminController {

  private final AdminService adminService;

  public AdminController(AdminService adminService) {
    this.adminService = adminService;
  }

  @PostMapping("/")
  public String create(@RequestParam CreateAdminRequest request) {
    adminService.create(request);
    return "ok";
  }

  @GetMapping()
  public AdminResponse getByEmail(@RequestParam("email") String email) {
    return Optional.ofNullable(adminService.findByEmail(email))
        .map(admin -> new AdminResponse(admin.getUserAccountId(), admin.getCompanyId()))
        .orElseGet(AdminResponse::new);
  }
}
