package com.transportation.controller;

import com.transportation.model.UserAccountModel;
import com.transportation.service.UserAccountService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

  private final UserAccountService userAccountService;

  public UserAccountController(UserAccountService userAccountService) {
    this.userAccountService = userAccountService;
  }

  @GetMapping("/{id}")
  public UserAccountModel getById(@PathVariable("id") Long id) {
    return userAccountService.getById(id);
  }

  @PutMapping
  public void update() {

  }

//  @PostMapping("/{id}")
//  public String delete(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
//    String username = userDetails.getUsername();
//    return Optional.ofNullable(userAccountService.getByEmail(username))
//        .filter(user -> user.getId().equals(id))
//        .map(user -> {
//              userAccountService.deleteById(user.getId());
//              return "redirect:/logout";
//            }
//        )
//        .orElse("private-area");
//  }
}
